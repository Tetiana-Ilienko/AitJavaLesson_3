public class Main {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread()); // Thread[main,5,main]
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()); // main

        System.out.println("Main  started");
        ThreadExample threadExample = new ThreadExample("Thread1");
        threadExample.printSamth();
        threadExample.start();
        System.out.println("Main finished");


    }




}
