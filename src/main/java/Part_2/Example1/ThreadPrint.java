package Part_2.Example1;

import javax.lang.model.element.Name;
import java.util.concurrent.CountDownLatch;

public class ThreadPrint extends Thread{
        private final CountDownLatch countDownLatch;
        private String print;

       public void name (String print) {
            this.print = print;
        }

    ThreadPrint(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }
        public synchronized void run() {
            for (int q = 0; q < 30; q++) {
                try {
                    Thread.sleep(2000);
                    System.out.print(print);
                    countDownLatch.countDown();
                    Thread.yield();
                    countDownLatch.await();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
}


