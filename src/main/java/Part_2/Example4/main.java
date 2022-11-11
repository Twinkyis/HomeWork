package Part_2.Example4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
public class main {

    public static Cars creatorCars(final int carsNumber) {
        return new  Cars (carsNumber, (int) (110 + Math.random() * 250));
        }

    public static void main(String[] args) throws InterruptedException {

        Cars.data.LATCH = new CountDownLatch(Cars.data.CountCar + 3);

        Cars.data.CONTROL_PLACES = new boolean[Cars.data.Tunnel_road_line];
        for (int i = 0; i < Cars.data.Tunnel_road_line; i++)
            Cars.data.CONTROL_PLACES[i] = true;
        Cars.data.SEMAPHORE = new Semaphore(Cars.data.CONTROL_PLACES.length, true);

        for (int i = 1; i <= Cars.data.CountCar; i++) {
                        new Thread (creatorCars(i)).start();
        }

        Thread.sleep(7100);
        System.out.println("На старт!");
        Cars.data.LATCH.countDown();  // Уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Внимание!");
        Cars.data.LATCH.countDown(); // Уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Начали!");
        Cars.data.LATCH.countDown(); // Уменьшаем счетчик на 1
    }
}