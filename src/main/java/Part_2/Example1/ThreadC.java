package Part_2.Example1;

public class ThreadC extends Thread{

    public synchronized void run() {

        for (int r = 0; r < 3; r++) {
            try {
                System.out.println("C");
                Thread.sleep(102);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
