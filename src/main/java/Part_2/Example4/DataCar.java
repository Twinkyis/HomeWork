package Part_2.Example4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class DataCar {
    public static final int Tunnel_road_line = 3;
    public static final int CountCar = 10;
    public static boolean[] CONTROL_PLACES = null;
    public static Semaphore SEMAPHORE = null;
    public static CountDownLatch LATCH;
}
