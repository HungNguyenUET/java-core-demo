package main.concurrency;

import java.util.concurrent.*;

public class CheckResults {
    private static int counter = 0;

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 50000; i++) {
                    CheckResults.counter++;
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            result.get(10, TimeUnit.SECONDS);
            System.out.println("Reached");
        } catch (TimeoutException | InterruptedException | ExecutionException e) {
            System.out.println("Not reached in time");
        } finally {
            if (service != null)
                service.shutdown();
        }
    }
}
