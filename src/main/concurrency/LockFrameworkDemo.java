package main.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockFrameworkDemo {
    public static void main(String[] args) {
        demo();
    }

    public static void demo() {
        Lock lock = new ReentrantLock();

        ExecutorService service = Executors.newFixedThreadPool(3);

        try {
            service.submit(() -> {
                try {
                    lock.lock();
                    System.out.println("1");
                    Thread.sleep(1000);
                    System.out.println("2");
                    Thread.sleep(1000);
                    System.out.println("3");
                    lock.unlock();
                } catch (Exception e) {
                    System.out.println("ERROR");
                }
            });

            service.submit(() -> {
                try {
                    lock.lock();
                    System.out.println("4");
                    Thread.sleep(1000);
                    System.out.println("5");
                    Thread.sleep(1000);
                    System.out.println("6");
                    lock.unlock();
                } catch (Exception e) {
                    System.out.println("ERROR");
                }
            });

            service.submit(() -> {
                try {
                    lock.lock();
                    System.out.println("7");
                    Thread.sleep(1000);
                    System.out.println("8");
                    Thread.sleep(1000);
                    System.out.println("9");
                    lock.unlock();
                } catch (Exception e) {
                    System.out.println("ERROR");
                }
            });
        } catch (Exception e) {
            System.out.println("ERROR");
        } finally {
            service.shutdown();
        }
    }
}
