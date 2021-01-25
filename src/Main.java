
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Tablou tablou = new Tablou();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Consumator(tablou));
        executorService.execute(new Producator(tablou));
        executorService.shutdown();

    }
}
