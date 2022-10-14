package Part_1.Stoping_threads;

public class Variant_01 extends Thread{

    public void run () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("усыпляет поток на заданное количество времени");
    }
}
