package Part_1.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerEx {

    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static void increment () {
        atomicInteger.addAndGet(5);
    }


}
