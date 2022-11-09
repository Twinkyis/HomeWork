package Part_2.Example4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class DataCar {
    public static final int COUNT_CONTROL_PLACES = 3;
    public static final int COUNT_RIDERS = 10;
    public static boolean[] CONTROL_PLACES = null;
    public static Semaphore SEMAPHORE = null;
    public static CountDownLatch LATCH;
}
