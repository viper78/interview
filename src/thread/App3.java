package thread;

// Use Synchronized and join()
public class App3 {

    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {

        App3 app3 = new App3();
        app3.doWork();
    }

    private void doWork() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            // join method helps to wait for the spawned threads to finish
            // execution before handing over control to the main thread.
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }


}
