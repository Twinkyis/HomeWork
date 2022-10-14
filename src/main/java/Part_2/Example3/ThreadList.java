package Part_2.Example3;

public class ThreadList extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            List1.syncList.add(i);
        }
    }
}
