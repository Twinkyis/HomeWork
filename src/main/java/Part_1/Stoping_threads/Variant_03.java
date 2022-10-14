package Part_1.Stoping_threads;

public class Variant_03 extends Thread{

    int count = 1;

    public void run() {

        while (count < 100) {
            try {
                Thread.sleep(1500);
                System.out.println("Попытка " + count++);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
break;
        }
    }
}
