package nothing;

public class CarThread extends Thread{
    public CarThread (String name) {
        setName(name);
    }
    @Override
    public void run() {
        System.out.println("car");
    }

    //comment
}
