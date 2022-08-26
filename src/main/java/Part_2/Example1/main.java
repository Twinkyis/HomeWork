package Part_2.Example1;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.*;

public class main {
    public static void main(String[] args) throws InterruptedException {

        ThreadPrint threadA = new ThreadPrint();
        ThreadB threadB = new ThreadB();
        ThreadC threadC = new ThreadC();

        threadA.name("A");
        threadB.name("B");
        threadC.name("C");

        threadA.setPriority(MAX_PRIORITY);
        threadB.setPriority(NORM_PRIORITY);
        threadC.setPriority(MIN_PRIORITY);

        threadA.start();
        threadB.start();
        threadC.start();

    }
}
