package Part_2.Example2;

import Part_2.Example2.ArrayList1;
import Part_2.Example2.Thread_1;
import Part_2.Example2.Thread_2;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class main1 {
    public static void main(String[] args) throws InterruptedException {

        Thread_1 thread_1 = new Thread_1();
        Thread_2 thread_2 = new Thread_2();
        thread_2.setDaemon(true);

        thread_1.start();
        thread_2.start();
        thread_1.join();
        thread_2.join();

    }
}
