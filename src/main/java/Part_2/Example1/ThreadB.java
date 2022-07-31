package Part_2.Example1;

public class ThreadB extends Thread{

    public synchronized void run() {

        for (int w = 0; w < 3; w++) {
            try {
                System.out.print("B");
                Thread.sleep(101);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
