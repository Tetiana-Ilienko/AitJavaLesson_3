package Tread_Method_Join;

public class Demo {


    public static void main(String[] args) throws Exception{

        // сoздаем новый поток, используя класс Thred
        SumIntegers sum = new SumIntegers();
        sum.start();
        sum.join();

        System.out.println(sum.getCounter());

        // создаем новый поток с помощью интерфейса Runnable
        SumIntegers2 sumIntegers2 = new SumIntegers2();
        Thread thread = new Thread(sumIntegers2);
        thread.start();
    }
}
