package Part_2.Example4;

import java.sql.SQLException;

public class Main {

//    public static Car creatorCars(final int carsNumber) {
//        return new Car(carsNumber, (int) (110 + Math.random() * 250));
//        }

    public static void main(String[] args) throws InterruptedException, SQLException {

//        TrackBuilder trackBuilder = new TrackBuilder(14000, 17000, 12000,
//                3,10,1, );

//        Car.concurrencyControl.latch = new CountDownLatch(Track.MAX_NUMBER_OF_CARS_ON_TRACK + 3);
//        Car.concurrencyControl.latch2 = new CountDownLatch(Track.MAX_NUMBER_OF_CARS_ON_TRACK);
//
//        Track.CONTROL_PLACE_FOR_SEGMENT_2 = new boolean[Track.MAX_NUMBER_OF_CARS_INSIDE_SEGMENT_2];
//        for (int i = 0; i < Track.MAX_NUMBER_OF_CARS_INSIDE_SEGMENT_2; i++)
//            Track.CONTROL_PLACE_FOR_SEGMENT_2[i] = true;
//        Car.concurrencyControl.semaphore = new Semaphore(Track.CONTROL_PLACE_FOR_SEGMENT_2.length, true);
//
//        for (int i = 1; i <= Track.MAX_NUMBER_OF_CARS_ON_TRACK; i++) {
//                        new Thread (creatorCars(i)).start();
//        }
//
//        Thread.sleep(7100);
//        System.out.println("На старт!");
//        Car.concurrencyControl.latch.countDown();  // Уменьшаем счетчик на 1
//        Thread.sleep(1000);
//        System.out.println("Внимание!");
//        Car.concurrencyControl.latch.countDown(); // Уменьшаем счетчик на 1
//        Thread.sleep(1000);
//        System.out.println("Начали!");
//        Car.concurrencyControl.latch.countDown(); // Уменьшаем счетчик на 1
//
//        TableLeaders tableLeaders = new TableLeaders();
//        tableLeaders.start();
//        tableLeaders.join();
    }
}