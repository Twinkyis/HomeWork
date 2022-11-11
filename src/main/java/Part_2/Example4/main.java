package Part_2.Example4;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
public class main {

    public static Car creatorCars(final int carsNumber) {
        return new Car(carsNumber, (int) (110 + Math.random() * 250));
        }

    public static void main(String[] args) throws InterruptedException {

        Car.data.LATCH = new CountDownLatch(Car.data.CountCar + 3);

        Car.data.CONTROL_PLACES = new boolean[Car.data.Tunnel_road_line];
        for (int i = 0; i < Car.data.Tunnel_road_line; i++)
            Car.data.CONTROL_PLACES[i] = true;
        Car.data.SEMAPHORE = new Semaphore(Car.data.CONTROL_PLACES.length, true);

        for (int i = 1; i <= Car.data.CountCar; i++) {
                        new Thread (creatorCars(i)).start();
        }

        Thread.sleep(7100);
        System.out.println("На старт!");
        Car.data.LATCH.countDown();  // Уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Внимание!");
        Car.data.LATCH.countDown(); // Уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Начали!");
        Car.data.LATCH.countDown(); // Уменьшаем счетчик на 1
    }
}