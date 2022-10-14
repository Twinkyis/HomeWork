package Part_2.Example4;

public class Car extends Thread{

    public static double rnd(final int max) {
        return Math.random() * max;
    }
    final int max = (int) 11.;
    final int rnd = (int) rnd(max);

    @Override
    public void run() {
        try {
            Thread.sleep(rnd);
            System.out.println("Car started");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
