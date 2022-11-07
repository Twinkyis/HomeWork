package Part_2.Example2;

import Part_2.Example2.ArrayList1;
import Part_2.Example2.Thread_1;
import Part_2.Example2.Thread_2;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import static java.lang.System.in;

public class main1 {
    public static void main(String[] args) throws Exception {


        Callable<String> thread_1 = new Thread_1();
        FutureTask futureTask = new FutureTask(thread_1);
        Thread_2 thread_2 = new Thread_2();
        thread_2.setDaemon(true);

        new Thread(futureTask).start();
        thread_2.start();
        thread_2.join();
        System.out.print(futureTask.get());
    }
}
