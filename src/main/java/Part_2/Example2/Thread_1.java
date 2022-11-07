package Part_2.Example2;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class Thread_1 implements Callable {

    @Override
    public Object call() {

        ArrayList1 arrayList1 = new ArrayList1();

        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        c = in.nextInt();
        in.close();

        return arrayList1.list2.get(c);
    }
   public static Integer c = null;
}
