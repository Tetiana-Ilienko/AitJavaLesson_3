package Variant_Method_Synchr;

public class ThreadCount1 implements Runnable{

    CounterCommon1 result1;

    public ThreadCount1(CounterCommon1 result1) {
        this.result1 = result1;
    }


    @Override
    public void run() {
        result1.increment();
    }
}
