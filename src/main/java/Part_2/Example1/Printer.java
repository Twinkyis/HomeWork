package Part_2.Example1;

public class Printer {

    private int printCount;
    private String lastPrint;
    private final int maxPrintCount;
    private final long restTimeInMillis;

    public Printer(int maxPrintCount, long restTimeInMillis) {
        if(maxPrintCount <= 0) throw new RuntimeException("Max print count should be bigger than 0");
        if(restTimeInMillis <= 0) throw new RuntimeException("Max rest time in should be bigger than 0");

        this.maxPrintCount = maxPrintCount;
        this.restTimeInMillis = restTimeInMillis;
    }

    public synchronized void print(String str) {
        lastPrint = str;
        if (isPrinterAvailable()) {
            System.out.print(str);
        }
        ++printCount;
    }

    boolean isPrinterAvailable() {
        return printCount < maxPrintCount;
    }

    public long getRestTimeInMillis() {
        return this.restTimeInMillis;
    }

    public String getLastPrint() {
        return lastPrint;
    }
}
