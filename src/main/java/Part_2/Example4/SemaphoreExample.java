package Part_2.Example4;

import java.util.concurrent.Semaphore;

public class SemaphoreExample
{
    private static final int COUNT_CONTROL_PLACES = 5;
    private static final int COUNT_RIDERS = 7;
    // Флаги мест контроля
    private static boolean[] CONTROL_PLACES = null;
    // Семафор
    private static Semaphore SEMAPHORE = null;

    public static class Rider implements Runnable
    {
        private int riderNum;

        public Rider(int ruderNum)  {
            this.riderNum = ruderNum;
        }

        @Override
        public void run() {
            System.out.printf(
                    "Всадник %d подошел к зоне контроля\n",
                    riderNum);
            try {
                // Запрос разрешения
                SEMAPHORE.acquire();
                System.out.printf(
                        "\tвсадник %d проверяет наличие cвободного контроллера\n", riderNum);
                int controlNum = -1;
                // Ищем свободное место и
                // подходим к контроллеру
                synchronized (CONTROL_PLACES){
                    for (int i = 0;
                         i < COUNT_CONTROL_PLACES; i++)
                        // Есть ли свободные контроллеры?
                        if (CONTROL_PLACES[i]) {
                            // Занимаем место
                            CONTROL_PLACES[i] = false;
                            controlNum = i;
                            System.out.printf(
                                    "\t\tвсадник %d подошел к контроллеру %d.\n",
                                    riderNum, i);
                            break;
                        }
                }

                // Время проверки лошади и всадника
                Thread.sleep((int)
                        (Math.random() * 10+1)*1000);

                // Освобождение места контроля
                synchronized (CONTROL_PLACES) {
                    CONTROL_PLACES[controlNum] = true;
                }

                // Освобождение ресурса
                SEMAPHORE.release();
                System.out.printf(
                        "Всадник %d завершил проверку\n",
                        riderNum);
            } catch (InterruptedException e) {}
        }
    }
    public static void main(String[] args)
            throws InterruptedException
    {
        // Определяем количество мест контроля
        CONTROL_PLACES = new boolean[COUNT_CONTROL_PLACES];
        // Флаги мест контроля [true-свободно,false-занято]
        for (int i = 0; i < COUNT_CONTROL_PLACES; i++)
            CONTROL_PLACES[i] = true;
        /*
         *  Определяем семафор со следующими параметрами :
         *  - количество разрешений 5
         *  - флаг очередности fair=true (очередь
         *                             first_in-first_out)
         */
        SEMAPHORE = new Semaphore(CONTROL_PLACES.length,
                true);

        for (int i = 1; i <= COUNT_RIDERS; i++) {
            new Thread(new Rider(i)).start();
            Thread.sleep(400);
        }
    }
}