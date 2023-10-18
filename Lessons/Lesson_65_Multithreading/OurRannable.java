public class OurRannable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
    }
}
