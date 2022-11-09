package Part_2.Example4;

public class timerForReady {

    final int max = 7000;
    final int rnd = rnd(max);
    public static int rnd(final int max) {
        return (int) (Math.random() * max);
    }

}
