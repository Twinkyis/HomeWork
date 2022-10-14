package Part_1.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class RunnableEx implements Runnable{

    AtomicIntegerEx atomicIntegerEx = new AtomicIntegerEx();

    @Override
    public void run() {
            for (int a = 0; a<100 ; a++) {
                atomicIntegerEx.increment();
            }
    }
}
