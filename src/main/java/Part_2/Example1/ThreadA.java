package Part_2.Example1;

public class ThreadA extends Thread{

    public synchronized void run() {

        for (int q = 0; q < 3; q++) {
            try {
                System.out.print("A");
                Thread.sleep(100);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
