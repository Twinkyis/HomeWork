package Part_1.sync;

public class sync_threads extends Thread {

    @Override
    public synchronized void run() {

       int i = 0;
        while (i < 5) {
            System.out.println("try " + i++);
        }
    }
}
