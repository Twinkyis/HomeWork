package Part_2.Example4;

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
            System.out.print(timerForReady1.rnd);
            System.out.println(" car " + carsNumber + " ready");
            main.dataCar.LATCH.countDown();
            main.dataCar.LATCH.await();

            Thread.sleep(main.dataCar.trackLength / carsSpeed * 10);

            System.out.println("car " + carsNumber + " finished");
        } catch (InterruptedException e) {
        }


    }
}
