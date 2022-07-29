
import Part_1.Create_threads.Variant_1;
import Part_1.Create_threads.Variant_2;
import Part_1.Demon.ThreadDaemon;
import Part_1.Stoping_threads.Variant_01;
import Part_1.Stoping_threads.Variant_02;
import Part_1.Stoping_threads.Variant_03;
import Part_1.sync.sync_threads;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

//===============================================================================================

    // потокобезопасные коллекции: два типа из которых выходят все потокобезопасные коллекции - cuncurrent и copyOnWrite

        // cuncurrent используется при необходимости одновременного доступа к одной коллекции




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

        // copyOnWrite используется когда доступ на чтение больше чем на запись. Суть в том, что при записи создается внутренняя копия на которую вносятся изменения
        // что позволяет предоставить доступ коллекции нескольким потокам

        






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