public class MoltiDemo extends Thread{
 // метод run() - это и есть тот метод, который выполняется в потоке

    public MoltiDemo (String name){
        super(name);
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start");
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
