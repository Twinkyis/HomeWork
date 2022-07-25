package Part_1.Demon;

public class ThreadDaemon extends Thread{
        int a1 = 1;

    @Override
    public void  run() {
        while (a1 < 500) {
            System.out.println("попытка" + a1++);
        }
    }
}
