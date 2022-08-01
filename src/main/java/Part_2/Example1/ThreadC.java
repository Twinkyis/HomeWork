package Part_2.Example1;

public class ThreadC extends Thread{

    public synchronized void run() {

        for (int r = 0; r < 3; r++) {
                try {
                    Thread.sleep(130);
                    System.out.println("C");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }

    }
}
