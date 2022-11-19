package Part_2.Example4;

public class Car extends Thread {

    static ConcurrencyControl concurrencyControl = new ConcurrencyControl();

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

//    public void run() {
//        try {
//            StopWatch stopWatch = new StopWatch(); // add StopWatch
//            Thread.sleep(rnd);
//            System.out.print("car " + carNumber + " ready ");
//            System.out.println("[ " + rnd + " millis" + " ]");
//            concurrencyControl.latch.countDown();
//            concurrencyControl.latch.await();
//            stopWatch.start(); // start StopWatch
//            Thread.sleep(Track.SEGMENT_1_LENGTH / carsSpeed);
//            System.out.println("авто " + carNumber + " подьехало к туннелю");
//            try {
//                concurrencyControl.semaphore.acquire();
//                int controlNum = -1;
//                synchronized (Track.CONTROL_PLACE_FOR_SEGMENT_2) {
//                    for (int a = 0;
//                         a < Track.MAX_NUMBER_OF_CARS_INSIDE_SEGMENT_2; a++)
//                        if (Track.CONTROL_PLACE_FOR_SEGMENT_2[a]) {
//                            Track.CONTROL_PLACE_FOR_SEGMENT_2[a] = false;
//                            controlNum = a;
//                            System.out.println("авто " + carNumber + " заехал в туннель");
//                            break;
//                        }
//                }
//                Thread.sleep(Track.SEGMENT_2_LENGTH / carsSpeed);
//                synchronized (Track.CONTROL_PLACE_FOR_SEGMENT_2) {
//                    Track.CONTROL_PLACE_FOR_SEGMENT_2[controlNum] = true;
//                }
//                concurrencyControl.semaphore.release();
//                System.out.println("авто " + carNumber + " выехало из туннеля ");
//            } catch (InterruptedException e) {
//            }
//            Thread.sleep(Track.SEGMENT_3_LENGTH / carsSpeed);
//            System.out.println("car " + carNumber + " finished");
//            stopWatch.stop(); // stop StopWatch
//
//            Cars cars = new Cars();
//            cars.setidCar(carNumber);
//            cars.setnameCar("bob");
//            cars.setTotalTime((int) stopWatch.getElapsedTime());
//
//            CarService carService = new CarService();
//            carService.updateProduct(cars);
//
//            concurrencyControl.latch2.countDown();
//
//        } catch (InterruptedException | SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}