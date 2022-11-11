package Part_2.Example4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Data {
    public int Tunnel_road_line = 3;
    public int CountCar = 10;
    public Semaphore SEMAPHORE = null;
    public CountDownLatch LATCH;
    public static boolean[] CONTROL_PLACES = null;
}
