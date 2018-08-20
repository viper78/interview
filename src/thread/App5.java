package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Using ExecutorService to group threads - Thread Group
public class App5 {

    public static void main(String[] args) {

        App5 app5 = new App5();
        app5.doWork();
    }

    public void doWork() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Processor(i));
        }

        executorService.shutdown(); // Non blocking

        System.out.println("Started processing...");

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS); // Blocking
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed processing");
    }

    class Processor implements Runnable {

        private int id;

        public Processor(int id) {
            this.id = id;
        }

        @Override
        public void run() {

            System.out.println("Starting :"+ id);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Completed :"+ id);
        }
    }
}
