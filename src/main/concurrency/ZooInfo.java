package main.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZooInfo {
    public static void main(String[] args) {
        ExecutorService service = null;
        ExecutorService service1 = null;

        Runnable task1 = () ->
                System.out.println("Printing zoo inventory");

        Runnable task2 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Printing record: " + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        try {
            service = Executors.newSingleThreadExecutor();
            service1 = Executors.newSingleThreadExecutor();

            System.out.println("begin");

            service1.execute(task2);
            service.execute(task1);
            service.execute(task1);
            System.out.println("end");
        } finally {
            if (service != null)
                service.shutdown();

            if (service1 != null)
                service1.shutdown();
        }
    }
}
