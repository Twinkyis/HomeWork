package Part_2.Example2;

import java.util.Scanner;

public class Thread_1 extends Thread{
   public static Integer c = null;

    @Override
    public void run() {

        ArrayList1 arrayList1 = new ArrayList1();

        for (String s : arrayList1.list2) {}

        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        c = in.nextInt();

       try {
           Thread.sleep(5000);
           System.out.print(arrayList1.list2.get(c));
           in.close();
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
    }
}
