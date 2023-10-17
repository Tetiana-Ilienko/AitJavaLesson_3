public class PrintingChar extends Thread {

    private char ch;

    public PrintingChar(char ch){
        this.ch = ch;
    }


    public void run(){
        System.out.println(Thread.currentThread().getName() + " started");
        for (int i = 0; i < 100; i++) {

            System.out.println(ch);

            try {
                sleep(5);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            if(i==50) {
                System.out.println(Thread.currentThread().getName() + " printed 50 times");
            }


        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
