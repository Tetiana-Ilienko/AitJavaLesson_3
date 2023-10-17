public class MainHW65 {

    /*
    Написать метод 100 раз печатающий char и вывести на экран результат его работы для двух потоков
    ( например, один поток печатает # , второй *). В конце должно выводиться " end of main"
     */

    public static void main(String[] args) {

        System.out.println("Main started");

        PrintingChar printingChar1 = new PrintingChar('#');
        printingChar1.start();

        PrintingChar printingChar2 = new PrintingChar('*');
        printingChar2.start();

        try {
            printingChar1.join();
            printingChar2.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Main finished");




    }

}
