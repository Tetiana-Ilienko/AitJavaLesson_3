package Tread_Method_Join;

public class SumIntegers extends Thread{

    int counter;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter++;

        }
    }

    public int getCounter() {
        return counter;
    }
}
