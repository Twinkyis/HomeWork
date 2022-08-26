package Part_2.Example1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;

public class ThreadPrint extends Thread{

    static CountDownLatch countDownLatch = new CountDownLatch(3);

    private String print;
    public void name (String print){
        this.print = print;
    }

    public synchronized void run() {

        for (int q = 0; q < 3; q++) {
            
            try {
                System.out.print(print);
                countDownLatch.countDown();
                Thread.yield();
                } catch (Exception e) {
                    throw new RuntimeException(e);
            }
        }
    }
}
