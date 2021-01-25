import java.util.Random;

public class Consumator implements Runnable {
    Tablou tablou;

    Consumator(Tablou tablou) {
        this.tablou = tablou;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 30; i++) {
                System.out.println("Consumator: " + tablou.citeste());
                Thread.sleep(Math.abs(new Random().nextLong()) % 100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}