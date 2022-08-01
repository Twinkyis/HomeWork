package Part_2.Example1;

public class ThreadB extends Thread{

    public synchronized void run() {

        for (int w = 0; w < 3; w++) {
                try {
                    Thread.sleep(110);
                    System.out.print("B");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        }
}
