package thread;

// Test for Volatile.
public class App2 {

    public static void main(String[] args) throws InterruptedException {
        Runner2 runner2 = new Runner2();
        runner2.start();
        Thread.sleep(2000);
        runner2.shutdown();
    }
}

class Runner2 extends Thread {

    private volatile boolean isRunning = true;
    @Override
    public void run() {

        while (isRunning) {
            System.out.println("Hello");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        isRunning = false;
    }
}