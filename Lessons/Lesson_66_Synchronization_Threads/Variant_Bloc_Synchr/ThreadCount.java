package Variant_Bloc_Synchr;

public class ThreadCount implements Runnable{

    CounterCommon result;

    public ThreadCount(CounterCommon result) {
        this.result = result;
    }

    @Override
    public void run() {
        synchronized (result){
        result.counter = 1;
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + result.counter);
            result.counter++;

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }}
}
