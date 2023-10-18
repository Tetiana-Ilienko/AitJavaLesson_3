package Atomic_Integer;

import java.util.concurrent.atomic.AtomicInteger;

public class OurAtomicInteger  {
    /*
    AtomicInteger - это класс из пакета java.util.concurrent.atomic, который представляет собой целое число (int),
    которое можно изменять атомарно. Это значит, что операции инкремента, декремента и обновления значения AtomicInteger
    выполняются непрерывно, без возможности между ними вмешивания других потоков.

AtomicInteger очень полезен в многопоточных приложениях, где несколько потоков могут изменять одну и ту же переменную.
Он обеспечивает безопасность доступа к этой переменной без необходимости использования явных блокировок.
     */

    public static void main(String[] args) throws InterruptedException{

        // создание
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger);

        AtomicInteger atomicInteger1 = new AtomicInteger(123);

        // получить значение
        int value = atomicInteger1.get();
        System.out.println(value);

        //  установить значение

        atomicInteger.set(456);

        //  добавить значение
        AtomicInteger atomicInteger2 = new AtomicInteger(1);
        System.out.println(atomicInteger2.getAndAdd(10));// сначала получить, потом увеличить -  в этой строке
                                                         // выведется единица

        System.out.println(atomicInteger2.get()); // 11


        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger); // 457, к значению добавили единицу
        atomicInteger.getAndIncrement();// получить значение и увеличить на единицу
        System.out.println(atomicInteger); // 458


       //***************************************************

       final Counter counter = new Counter();
       //пусть счетчик считает до тысячи тысячу потоков

        for (int i = 0; i < 1000; i++) {
            new Thread(counter::increment).start(); // ()-> counter.increment()

        }
        Thread.sleep(3000);

        System.out.println("Final number (should  be 1000)" + counter.value());


    }





}
