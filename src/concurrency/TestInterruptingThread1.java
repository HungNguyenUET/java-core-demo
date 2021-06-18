package concurrency;

public class TestInterruptingThread1 extends Thread {

    public void run() {
        for (int i = 1; i <= 5; i++)
            System.out.println(i);
    }

    public static void main(String args[]) {
        TestInterruptingThread1 t1 = new TestInterruptingThread1();
        t1.start();
        t1.interrupt();
    }

}
