package Part_2.Example4;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
public class main {
    public static Cars creatorCars (final int carsNumber) {
        return new  Cars (carsNumber, (int) (Math.random() * 10 + 5));
    }
    static DataCar dataCar = new DataCar();
    static Roads roads =  new Roads();

    public static void main(String[] args) throws InterruptedException {

        dataCar.LATCH = new CountDownLatch(dataCar.CountCar + 3);

        dataCar.CONTROL_PLACES = new boolean[dataCar.Tunnel_road_line];
        for (int i = 0; i < dataCar.Tunnel_road_line; i++)
            dataCar.CONTROL_PLACES[i] = true;
        dataCar.SEMAPHORE = new Semaphore(dataCar.CONTROL_PLACES.length, true);

        for (int i = 1; i <= dataCar.CountCar; i++) {
            new Thread (creatorCars(i)).start();
        }

        Thread.sleep(7100);
        System.out.println("На старт!");
        dataCar.LATCH.countDown();  // Уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Внимание!");
        dataCar.LATCH.countDown(); // Уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Начали!");
        dataCar.LATCH.countDown(); // Уменьшаем счетчик на 1

    }
}