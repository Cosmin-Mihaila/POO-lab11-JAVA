import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tablou {
    static final int CAPACITATE = 10;
    LinkedList<Integer> lista = new LinkedList<>();
    Lock lock = new ReentrantLock();
    Condition neVid = lock.newCondition();
    Condition nePlin = lock.newCondition();


    void scrie(int valoare) {
        lock.lock();

        try {
            while (CAPACITATE == lista.size()) {
                nePlin.await();
            }
            lista.offer(valoare);
            neVid.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    Integer citeste() {
        lock.lock();
        Integer out = -1;

        try {
            while (lista != null && lista.size() == 0) {
                neVid.await();
            }
            out = lista.remove();
            nePlin.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return out;
    }
}