package Part_2.Example1;

public class Print implements Runnable {

    private final String print;
    private final Printer printer;
    private final String printAfter;

    public Print(String print, Printer printer, String printAfter) {
        if(print == null) throw new RuntimeException("Print string should not be null");
        if(printAfter == null) throw new RuntimeException("Print after string should not be null");

        this.print = print;
        this.printer = printer;
        this.printAfter = printAfter;
    }

    @Override
    public void run() {
        while (printer.isPrinterAvailable()) {
            if (isPrintTime()) {
                printer.print(print);
            }
            sleep();
        }
    }

    private boolean isPrintTime() {
        return printer.getLastPrint() == null
                || printAfter.equals(printer.getLastPrint());
    }

    private void sleep() {
        try {
            Thread.sleep(printer.getRestTimeInMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
