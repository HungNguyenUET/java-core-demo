package main.concurrency;

import java.util.List;
import java.util.concurrent.*;

public class CurrencyDemo {
    private static int count = 0;

    public static void main(String[] args) {
        testAvailableProcessors();
    }

    private static void testAvailableProcessors() {

        int processorAmount = Runtime.getRuntime().availableProcessors();
        System.out.println("Start, processorAmount: " + processorAmount);

        Callable<String> task = () -> {
            while (true) {
                count++;
            }
        };
        Callable<String> task1 = () -> {
            while (true) {
                count++;
            }
        };
        Callable<String> task2 = () -> {
            while (true) {
                count++;
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(task);
        service.submit(task1);
        service.submit(task2);

        int processorAmount1 = Runtime.getRuntime().availableProcessors();
        System.out.println("End, processorAmount: " + processorAmount1);
    }

    private static void invokeAnyDemo() {
        int processorAmount = Runtime.getRuntime().availableProcessors();
        System.out.println("processorAmount: " + processorAmount);

        ExecutorService service = Executors.newFixedThreadPool(3);
        System.out.println("begin");
        Callable<String> task = () -> "result 0";
        Callable<String> task1 = () -> {
            Thread.sleep(1000);
            return "result 1";
        };
        Callable<String> task2 = () -> "result 2";

        try {
            String data = service.invokeAny(List.of(task1, task, task2));
            System.out.println(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }

        System.out.println("end");
    }

    private static void invokeManyDemo() {
        ExecutorService service = Executors.newSingleThreadExecutor();

        System.out.println("begin");

        Callable<String> task = () -> "result";

        try {
            List<Future<String>> list = service.invokeAll(List.of(task, task, task));

            for (Future<String> future : list) {
                System.out.println(future.get());
            }

        } catch (InterruptedException e) {
            System.out.println("Error start list of task");
        } catch (ExecutionException e) {
            System.out.println("Error get results");
        }

        System.out.println("end");
    }
}
