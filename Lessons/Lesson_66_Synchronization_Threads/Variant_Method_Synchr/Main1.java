package Variant_Method_Synchr;

public class Main1 {
    public static void main(String[] args) {
        CounterCommon1 counterCommon = new CounterCommon1();

        for (int i = 1; i <  5 ; i++) {
            Thread thread = new Thread(new ThreadCount1(counterCommon), "Child " + i);
            thread.start();

        }
    }
}
