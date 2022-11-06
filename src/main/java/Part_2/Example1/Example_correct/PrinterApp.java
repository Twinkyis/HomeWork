package Part_2.Example1.Example_correct;

public class PrinterApp {
    public static void main(String[] args) {
        int numberOfPrints = 12;
        long restTimeInMillis = 1000;

        Printer printer = new Printer(numberOfPrints, restTimeInMillis);

        new Thread(new Print("A", printer, "\n")).start();
        new Thread(new Print("B", printer, "A")).start();
        new Thread(new Print("C", printer, "B")).start();
        new Thread(new Print("\n", printer, "C")).start();
    }
}
