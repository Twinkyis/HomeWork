package Part_2.Example4;


import dao.CarService;
import dao.Cars;

import java.sql.SQLException;
import java.util.ArrayList;

public class Car extends Thread {

    ArrayList<Integer> carNum = new ArrayList<>();
    ArrayList<Integer> carTime = new ArrayList<>();

    Track track =  new Track();
    static Data data = new Data();

    final int max = 7000;
    final int rnd = rnd(max);
    public int rnd(final int max) {
        return (int) (Math.random() * max);
    }

    private final int carNumber;
    private final int carsSpeed;

    public Car(int carNumber, int carsSpeed) {
        this.carNumber = carNumber;
        this.carsSpeed = carsSpeed;
    }

    public void run() {
        try {
            StopWatch stopWatch = new StopWatch(); // add StopWatch
            Thread.sleep(rnd);
            System.out.print("car " + carNumber + " ready ");
            System.out.println("[ " + rnd + " millis" + " ]");
            data.LATCH.countDown();
            data.LATCH.await();
            stopWatch.start(); // start StopWatch
            Thread.sleep(track.trackLength1 / carsSpeed);
            System.out.println("авто " + carNumber + " подьехало к туннелю");
                try {
                    data.SEMAPHORE.acquire();
                    int controlNum = -1;
                    synchronized (data.CONTROL_PLACES) {
                        for (int a = 0;
                        a < data.Tunnel_road_line; a++)
                            if (data.CONTROL_PLACES[a]) {
                            data.CONTROL_PLACES[a] = false;
                            controlNum = a;
                            System.out.println("авто " + carNumber + " заехал в туннель");
                            break;
                            }
                    }
                    Thread.sleep(track.trackLength2 / carsSpeed);
                    synchronized (data.CONTROL_PLACES) {
                    data.CONTROL_PLACES[controlNum] = true;
                    }
                    data.SEMAPHORE.release();
                    System.out.println("авто " + carNumber + " выехало из туннеля ");
                } catch (InterruptedException e) {
                }
            Thread.sleep(track.trackLength3 / carsSpeed);
                System.out.println("car " + carNumber + " finished");
            stopWatch.stop(); // stop StopWatch

            data.LATCH2.countDown();

            Cars cars = new Cars();
            cars.setidCar(carNumber);
            cars.setTotalTime((int) stopWatch.getElapsedTime());
            cars.setnameCar("bob");

            CarService carService = new CarService();
            carService.updateProduct(cars);

            }  catch (InterruptedException | SQLException e){
            throw new RuntimeException(e);
        }
    }
}