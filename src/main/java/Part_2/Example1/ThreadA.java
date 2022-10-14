//package Part_2.Example1;
//
//import java.util.concurrent.CountDownLatch;
//
//public class ThreadA extends Thread{
//
//    private final CountDownLatch countDownLatch;
//    private String print = "A";
//
//    ThreadA(CountDownLatch countDownLatch) {
//        this.countDownLatch = countDownLatch;
//        this.start();
//    }
//    public synchronized void run() {
//        for (int q = 0; q < 30; q++) {
//            if () {
//            try {
//                System.out.print(print);
//                countDownLatch.countDown();
//                countDownLatch.await();
//
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//            }
//            } else {
//                try {
//
//                    Thread.sleep(100);
//
//                } catch (InterruptedException e) {
//
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }
//}
