package Part_2.Example4;


import java.util.concurrent.CountDownLatch;

public class main {

    public static Cars creatorCars (final int carsNumber) {
        return new  Cars (carsNumber, (int) (Math.random() * 10 + 5));
    }
    static DataCar dataCar = new DataCar();

    public static void main(String[] args) throws InterruptedException {


        dataCar.LATCH = new CountDownLatch(dataCar.Car_Count + 3);

        for (int i = 1; i <= dataCar.Car_Count; i++) {
            new Thread (creatorCars(i)).start();
        }

        Thread.sleep(7100);
        System.out.println("На старт!");
        dataCar.LATCH.countDown();  // Уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Внимание!");
        dataCar.LATCH.countDown(); // Уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Марш!");
        dataCar.LATCH.countDown(); // Уменьшаем счетчик на 1

    }
}