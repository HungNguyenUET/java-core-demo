package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    static class RequestHandler implements Runnable {
        private String name;

        public RequestHandler(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                String curThreadName = Thread.currentThread().getName();
                System.out.println(curThreadName + " starting process " + name);
                Thread.sleep(100);
                System.out.println(curThreadName + " finished process " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorsDemo demo = new ExecutorsDemo();
        demo.singleThreadPoolDemo();
        demo.fixedThreadPoolDemo();
        demo.cachedThreadPoolDemo();
    }

    private void process(ExecutorService executor) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            executor.execute(new RequestHandler("request" + i));
            Thread.sleep(100);
        }
        executor.shutdown();

        while (true) {
            if (executor.isTerminated()) {
                long endTime = System.currentTimeMillis();
                long executeTime = endTime - startTime;
                System.out.println("SingleThreadPool is terminated after: " + executeTime);
                break;
            }
        }
    }

    private void singleThreadPoolDemo() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        process(executor);
    }

    private void fixedThreadPoolDemo() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(12);
        process(executor);
    }

    private void cachedThreadPoolDemo() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        process(executor);
    }

}
