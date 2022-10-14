package Part_1.Create_threads;

public class Variant_2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Создает поток посредством интерфейса Runnable");
    }
}
// больше вариантов по сути нет, так как все потоки создаються через Thread