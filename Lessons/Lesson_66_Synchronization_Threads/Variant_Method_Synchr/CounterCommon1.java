package Variant_Method_Synchr;

public class CounterCommon1 {

    int counter;

    public synchronized void increment(){
        counter = 1;

    for (int i = 0; i < 4; i++) {
        System.out.println(Thread.currentThread().getName() + " : " + counter);
        counter++;

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }}


}
