package main.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {
//    private AtomicInteger sheepCount = new AtomicInteger(0);
    private int sheepCount = 0;
    private final Object herd = new Object();

    private void incrementAndReport() {
//        System.out.println((sheepCount.incrementAndGet()) + " ");
        synchronized (this) {
            System.out.println((sheepCount++) + " ");
        }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
