package main.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockFrameworkDemo {
    public static void main(String[] args) {
        demoTryLock2();
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

    public static void demoTryLock() {
        Lock lock = new ReentrantLock();
        new Thread(() -> printMessage(lock)).start();
        if (lock.tryLock()) {
            try {
                System.out.println("Lock obtained, entering protected code");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Unable to acquire lock, doing something else");
        }
    }

    public static void printMessage(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(3000);
            System.out.println("Locking by printMessage");
        } catch (Exception e){
            System.out.println("ERROR sleep");
        } finally {
            lock.unlock();
        }
    }

    private static void demoTryLock2() {
        Lock lock = new ReentrantLock();
//        lock.lock();

        if (lock.tryLock()) {
            try {
                System.out.println("Lock obtained, entering protected code");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Unable to acquire lock, doing something else");
        }
    }
}
