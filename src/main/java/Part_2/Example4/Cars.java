package Part_2.Example4;

import static Part_2.Example4.DataCar.CONTROL_PLACES;

public class Cars implements Runnable{
    private int carsNumber;
    private int carsSpeed;
    public Cars (int carsNumber, int carsSpeed) {
        this.carsNumber = carsNumber;
        this.carsSpeed = carsSpeed;
    }
    @Override
    public void run() {
        try {
            timerForReady timerForReady1 = new timerForReady();    // таймер до 7 секунд на подготовку
            Thread.sleep(timerForReady1.rnd);
            System.out.print("car " + carsNumber + " ready ");
            System.out.println("[ " + timerForReady1.rnd + " millis" + " ]");
            main.dataCar.LATCH.countDown();
            main.dataCar.LATCH.await();
            Thread.sleep(main.roads.trackLength1 / carsSpeed * 10);
            System.out.println("авто " + carsNumber + " подьехало к туннелю");

            try {
    main.dataCar.SEMAPHORE.acquire();
    System.out.println("проверка свободной полосы");
    int controlNum = -1;
    synchronized (CONTROL_PLACES) {
        for (int a = 0;
             a < main.dataCar.COUNT_CONTROL_PLACES; a++)
        if (CONTROL_PLACES[a]) {
            CONTROL_PLACES[a] = false;
            controlNum = a;
            System.out.println("авто " + carsNumber + " заехал в туннель");
            break;
        }
    }
    Thread.sleep(main.roads.trackLength3 / carsSpeed * 10);
    synchronized (CONTROL_PLACES) {
        CONTROL_PLACES[controlNum] = true;
    }
    // Освобождение ресурса
    main.dataCar.SEMAPHORE.release();
    System.out.printf(
            " авто выехало из туннеля " + carsNumber);
                } catch (InterruptedException e) {}
                Thread.sleep(main.roads.trackLength3 / carsSpeed * 10);
                System.out.println("car " + carsNumber + " finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
