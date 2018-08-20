package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Multiple object locks instead of synchronized method.
// Since synchronized on monitor object locks entire object,
// it increases execution time, as oppsed to two different locks
// for two distinct operations.
public class App4 {

    private List<Integer> list1 = new ArrayList();
    private List<Integer> list2 = new ArrayList();
    Random random = new Random();
    Object lock1 = new Object();
    Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {

        App4 app4 = new App4();
        app4.doWork();
    }

//    private synchronized void stageOne() {
//        list1.add(random.nextInt(100));
//    }
//
//    private synchronized void stageTwo() {
//        list2.add(random.nextInt(100));
//    }

    private void stageOne() {
        synchronized (lock1) {
            list1.add(random.nextInt(100));
        }
    }

    private void stageTwo() {
        synchronized (lock2) {
            list2.add(random.nextInt(100));
        }
    }

    private void doWork() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2000; i++) {
                    stageOne();
                    stageTwo();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2000; i++) {
                    stageOne();
                    stageTwo();
                }
            }
        });

        long start = System.currentTimeMillis();
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long end = System.currentTimeMillis();

        System.out.println("Time Taken :" + (end - start) + " ms");
        System.out.println("List 1:" + list1.size() + " List 2:"+ list2.size());
    }
}
