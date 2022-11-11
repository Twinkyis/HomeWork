package Part_2.Example4;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;


public class Cars implements Runnable {

    private int carsNumber;
    private int carsSpeed;

    public Cars (int carsNumber, int carsSpeed) {
        this.carsNumber = carsNumber;
        this.carsSpeed = carsSpeed;
    }

    final int max = 7000;
    final int rnd = rnd(max);
    public int rnd(final int max) {
        return (int) (Math.random() * max);
    }

    Roads roads =  new Roads();
    static Data data = new Data();

    public void run() {
        try {
            StopWatch stopWatch = new StopWatch(); // add StopWatch
            Thread.sleep(rnd);
            System.out.print("car " + carsNumber + " ready ");
            System.out.println("[ " + rnd + " millis" + " ]");
            data.LATCH.countDown();
            data.LATCH.await();
            stopWatch.start(); // start StopWatch
            Thread.sleep(roads.trackLength1 / carsSpeed);
            System.out.println("авто " + carsNumber + " подьехало к туннелю");

                try {
                    data.SEMAPHORE.acquire();
                    int controlNum = -1;
                    synchronized (data.CONTROL_PLACES) {
                        for (int a = 0;
                        a < data.Tunnel_road_line; a++)
                            if (data.CONTROL_PLACES[a]) {
                            data.CONTROL_PLACES[a] = false;
                            controlNum = a;
                            System.out.println("авто " + carsNumber + " заехал в туннель");
                            break;
                            }
                    }

                    Thread.sleep(roads.trackLength2 / carsSpeed);
                    synchronized (data.CONTROL_PLACES) {
                    data.CONTROL_PLACES[controlNum] = true;
                    }
                    data.SEMAPHORE.release();
                    System.out.println("авто " + carsNumber + " выехало из туннеля ");
                } catch (InterruptedException e) {
                }

            Thread.sleep(roads.trackLength3 / carsSpeed);
                System.out.println("car " + carsNumber + " finished");
            stopWatch.stop(); // stop StopWatch
                System.out.println("car #" + carsNumber + " : Total time = " + stopWatch.getElapsedTimeSecs() + " millis : " + " max speed = " + carsSpeed);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
            }
    }
}

