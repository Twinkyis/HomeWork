import Part_1.Atomic.AtomicIntegerEx;
import Part_1.Atomic.RunnableEx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {

// функциональный интерфейс - интерфейс который содержит не более одного метода. эти интерфейсы можно писать самому или пользоваться существующими
// так же можно (нужно) использовать такие интерфейсы через аннотации

//        @FunctionalInterface
//        interface Predicate<T>{
//        boolean test (T t);
//        }

//===============================================================================================
        //атомарные типы данных нужны для того, что бы гарантировать выполнение операции путем неделимости (либо выполняется полностью либо не выполняется)
        //так же это операции, которые есть потокобезопасными но при этом не используют блокировок

//        RunnableEx runnableEx = new RunnableEx();
//
//
//        Thread thread1 = new Thread(runnableEx);
//        Thread thread2 = new Thread(runnableEx);
//
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//
//        System.out.println(AtomicIntegerEx.atomicInteger);

//===============================================================================================

        // cuncurrent используется при необходимости одновременного доступа к одной коллекции

//        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
//        concurrentHashMap.put(1, "num1");
//        concurrentHashMap.put(2, "num2");
//        concurrentHashMap.put(3, "num3");
//        concurrentHashMap.put(4, "num3");
//        concurrentHashMap.put(6, "num3");
//        concurrentHashMap.put(7, "num3");
//        System.out.println(concurrentHashMap);
//
//        Runnable runnable1 = () -> {
//            Iterator<Integer> integerIterator = concurrentHashMap.keySet().iterator();
//            while (integerIterator.hasNext()) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Integer i = integerIterator.next();
//                System.out.println(i + ":" + concurrentHashMap.get(i));
//            }
//        };
//
//            Runnable runnable2 = () -> {
//                try{
//                    Thread.sleep(300);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                concurrentHashMap.put(5, "SOME");
//            };
//
//            Thread thread1 = new Thread(runnable1);
//            Thread thread2 = new Thread(runnable2);
//
//            thread1.start();
//            thread2.start();
//            thread1.join();
//            thread2.join();
//
//        System.out.println(concurrentHashMap);


//===============================================================================================


        //синхронизированные коллекции - вид потокобезопасных коллеций созданных из обычных непотокобезопасных коллекций.
        // суть в заточении обычной коллекции в обретку которая делает коллекцию потокобезопасной путем lock на доступ к коллекции пока с ней работает один поток

//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("num_1");
//        arrayList.add("num_2");
//        arrayList.add("num_3");
//
//        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
//
//        Runnable runnable = () -> {syncList.addAll(arrayList);};
//
//        Thread thread1 = new Thread(runnable);
//        Thread thread2 = new Thread(runnable);
//
//        thread1.start();
//        thread2.start();
//
//        System.out.println(syncList);


//===============================================================================================

        // copyOnWrite используется когда доступ на чтение больше чем на запись. Суть в том, что при записи создается внутренняя копия на которую вносятся изменения
        // что позволяет предоставить доступ коллекции нескольким потокам

//        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
//        arrayList.add("num1");
//        arrayList.add("num2");
//        arrayList.add("num3");
//        arrayList.add("num4");
//        arrayList.add("num5");
//        arrayList.add("num6");
//        arrayList.add("num7");
//
//        Runnable runnable1 = () -> {
//            Iterator<String> iterator1 = arrayList.iterator();
//            while (iterator1.hasNext()) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(iterator1.next());
//            }
//        };
//
//            Runnable runnable2 = () -> {
//                try{
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                arrayList.remove(6);
//                arrayList.add("SEVEN_NUM");
//            };
//
//            Thread thread1 = new Thread(runnable1);
//            Thread thread2 = new Thread(runnable2);
//
//            thread1.start();
//            thread2.start();
//            thread1.join();
//            thread2.join();
//
//        System.out.println(arrayList);

        






//===============================================================================================

        // синхронизация потоков
//
//       int a;
//
//        for (a = 0; a < 3 ; a++) {
//            Thread threadSync = new Thread(new sync_threads());
//            threadSync.getName();
//            threadSync.start();
//        }





//===============================================================================================

        // Daemon отделяет поток от общего и завершает его внезависимости от того, когда завершается основной.

//        Thread threadDaemon = new Thread (new ThreadDaemon());
//        threadDaemon.setDaemon(true);
//        threadDaemon.start();
//        System.out.println("thread finished");

//===============================================================================================

        // Вариант 1 создания потока посредство наследования методов класса Thread

//        Variant_1 vr1 = new Variant_1();
//        vr1.start(); // start позволяет лишь единожды запустить один и тот же поток,
        // и после того как поток закончит свою жизнь больше его не запускать.
        // Для тестов можно использовать run, что бы было проще,
        // так как он позволяет запускать поток снова и снова нужно е количество раз

//===============================================================================================

        // Вариант 2 создания потока посредством реализации интерфейса Runnable,
        // но здесь будет отсутсвовать метод start

//        Variant_2 vr2 = new Variant_2();
//        vr2.run();

//===============================================================================================

        // Вариант 1 прерывания потока (вернее усыпление на заданное время)

//        Variant_01 v1 = new Variant_01();
//        v1.start();

//===============================================================================================
        // Вариант 2 прерывания потока
//        Variant_02 v2 = new Variant_02();
//
//        System.out.println("поток стартовал");
//        v2.start();
//        try {
//            Thread.sleep(50);
//
//            v2.interrupt();
//
//            Thread.sleep(50);  // не понял механику: если sleep установить значение "5", то выполнение потока будет выполнено после финиширования потока (согласно выводу в терминал)
//        } catch (InterruptedException e){
//            System.out.println("interrupted");
//        }
//        System.out.println("поток финишировал");

//===============================================================================================

        // Вариант 3 прерывания потока посредством команды break

//        System.out.println("Начало потока");
//        Variant_03 v3 = new Variant_03();
//        v3.start();

//===============================================================================================


    }
}