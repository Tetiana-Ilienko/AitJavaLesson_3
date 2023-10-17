public class ThreadExample extends Thread{


    public ThreadExample(String name){
        super(name);
    }


    public void printSamth(){
        System.out.println("Print");

    }

    public  void run (){
       // printSamth();
        System.out.println(Thread.currentThread().getName() +
                " started");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
