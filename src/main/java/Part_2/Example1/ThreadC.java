package Part_2.Example1;

import java.util.concurrent.CountDownLatch;

public class ThreadC extends Thread{


    private String print;
    public void name (String print){
        this.print = print;
    }

    public synchronized void run() {

        for (int q = 0; q < 3; q++) {

            try {
                System.out.println(print);
                ThreadPrint.countDownLatch.countDown();
                Thread.yield();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
