package main.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AwaitDemo {
    private static int count = 0;

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();

            System.out.println("Start!");

            service.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Sleep thread get error!!!");
                }

                for (int i = 0; i < 500; i++) {
                    count++;
                }

                System.out.println("Count: " + count + ", End!");
            });
        } finally {
            if (service != null) {

                System.out.println("Before await");

                try {
                    service.awaitTermination(3, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    System.out.println("Thread running timeout");
                }

                System.out.println("After await");
                service.shutdown();
            }
        }

        if (service.isShutdown()) {
            System.out.println("Shutdown");
        }

        if (service.isTerminated()) {
            System.out.println("Finished!");
        } else {
            System.out.println("At least on task is still running");
        }

        System.out.println("End of main function!");
    }
}
