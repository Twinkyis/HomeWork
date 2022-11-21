package Part_2.Example1;

import java.util.concurrent.atomic.AtomicInteger;

class ThreadPrinter implements Runnable
{
    private Object monitor = new Object();
    AtomicInteger atomicInt = new AtomicInteger(1);

    static boolean one = true;
    static boolean two = false;
    static boolean three = false;

    @Override
    public void run()
    {
        printSymbols();
    }

    public void printSymbols()
    {
        try
        {
            int i =0;
            while(i < 8)
            {
                synchronized (monitor)
                {
                    if(Thread.currentThread().getName().equals("Thread1")) {
                        if (atomicInt.get() == 1) {
                            System.out.print("A" + " ");
                            atomicInt.set(2);
                            monitor.notifyAll();
                        } else {
                            monitor.wait();
                        }
                    }

                    if(Thread.currentThread().getName().equals("Thread2")) {
                        if (atomicInt.get() == 2) {
                            System.out.print("B" + " ");
                            atomicInt.set(3);
                            monitor.notifyAll();
                        } else {
                            monitor.wait();
                        }
                    }

                    if(Thread.currentThread().getName().equals("Thread3")) {
                        if (atomicInt.get() == 3) {
                            System.out.print("C" + " ");
                            atomicInt.set(1);
                            monitor.notifyAll();
                        } else {
                            monitor.wait();
                        }
                    }
                }
                i++;
            }
        }
        catch(InterruptedException e)
        {
        }
    }
}