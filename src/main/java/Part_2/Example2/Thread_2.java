package Part_2.Example2;

public class Thread_2 extends Thread {

    @Override
    public void run() {

        while (Thread_1.c == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
                for (int i = 0; i < 5; i++) {

                    System.out.print(".");

                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException ex) {

                        throw new RuntimeException(ex);
                    }
                }
    }
}



