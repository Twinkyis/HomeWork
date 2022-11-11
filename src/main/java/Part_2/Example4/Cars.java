package Part_2.Example4;

import java.util.HashMap;
import java.util.concurrent.Callable;

import static Part_2.Example4.DataCar.CONTROL_PLACES;

public class Cars implements Runnable {
    private int carsNumber;
    private int carsSpeed;

    private int result;
    public Cars (int carsNumber, int carsSpeed) {
        this.carsNumber = carsNumber;
        this.carsSpeed = carsSpeed;
    }

    @Override
    public void run() {
        try {

            StopWatch stopWatch = new StopWatch(); // add StopWatch
            timerForReady timerForReady1 = new timerForReady();    // таймер до 7 секунд на подготовку
            Thread.sleep(timerForReady1.rnd);
            System.out.print("car " + carsNumber + " ready ");
            System.out.println("[ " + timerForReady1.rnd + " millis" + " ]");
            main.dataCar.LATCH.countDown();
            main.dataCar.LATCH.await();
            stopWatch.start(); // start StopWatch
            Thread.sleep(main.roads.trackLength1 / carsSpeed);
            System.out.println("авто " + carsNumber + " подьехало к туннелю");

            try {
    main.dataCar.SEMAPHORE.acquire();
    int controlNum = -1;
    synchronized (CONTROL_PLACES) {
        for (int a = 0;
             a < main.dataCar.Tunnel_road_line; a++)
        if (CONTROL_PLACES[a]) {
            CONTROL_PLACES[a] = false;
            controlNum = a;
            System.out.println("авто " + carsNumber + " заехал в туннель");
            break;
        }
    }
    Thread.sleep(main.roads.trackLength2 / carsSpeed);
    synchronized (CONTROL_PLACES) {
        CONTROL_PLACES[controlNum] = true;
    }
    main.dataCar.SEMAPHORE.release();
    System.out.println(
            "авто " + carsNumber + " выехало из туннеля ");
                } catch (InterruptedException e) {}

                Thread.sleep(main.roads.trackLength3 / carsSpeed);
                System.out.println("car " + carsNumber + " finished");
                stopWatch.stop(); // stop StopWatch
                TableLeaders.list.add(carsNumber);
//                System.out.println("car #" + carsNumber + " : Total time = " + stopWatch.getElapsedTimeSecs() + " millis : " + " max speed = " + carsSpeed);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

