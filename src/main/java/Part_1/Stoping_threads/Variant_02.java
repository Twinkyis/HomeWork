package Part_1.Stoping_threads;

public class Variant_02 extends Thread{

    int count = 1;

    public void run() {

        while (!isInterrupted()) {
            System.out.println("попытка " + count++);
        }
    }
}

