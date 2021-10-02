package main.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AwaitDemo {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();

        } finally {
            if (service != null) {
                service.shutdown();
            }
        }

        if (service != null) {
            service.awaitTermination(1, TimeUnit.MINUTES);
        }

        if (service.isTerminated()) {
            System.out.println("Finished!");
        } else {
            System.out.println("At least on task is still running");
        }
    }
}
