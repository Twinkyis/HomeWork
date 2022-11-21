package Part_2.Example1;

public class Main  {
    public static void main(String[] args) throws InterruptedException {

        final ThreadPrinter printRunnable = new ThreadPrinter();
        Thread t1 = new Thread(printRunnable, "Thread1");
        Thread t2 = new Thread(printRunnable,"Thread2");
        Thread t3 = new Thread(printRunnable,"Thread3");

        t1.start();
        t2.start();
        t3.start();
    }
}