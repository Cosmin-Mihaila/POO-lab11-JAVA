import java.util.Random;

public class Producator implements Runnable {
    Tablou tablou;

    Producator(Tablou tablou) {
        this.tablou = tablou;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 30; i++) {
                tablou.scrie(i);
                System.out.println("Producator: " + i);
                Thread.sleep(Math.abs(new Random().nextLong()) % 100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}