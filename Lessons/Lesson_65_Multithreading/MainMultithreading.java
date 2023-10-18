public class MainMultithreading {
    // Multithreading - многопоточность
    /*
    thread - нить
    Есть два вида многозадачности:
    1. process- based - когда выполняется одновременно несколько программ ( процесс).
    2. thread-based -  когда одновременно выполняется несколько задач в одной программе

    Возможные состояния потока:

    New - еще не запущенный поток
    Running - исполняющийся
    Blocked - заблокированный поток, который ждет возможности возобновления работы
    Waiting - состояние ожидания возобновления работы
    Terminated - закончивший работу

    многопоточность в Java основана на классе Thread и интерфейсе Runnable
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()); // main
        System.out.println(thread.getPriority()); // 5

         /*
        Основные методы класса Thread
         getName() - возвращает имя потока
         getPriority() - возвращает приоритет потока
         setPriority(int priority) -  установить приоритет потока
         isAlive() - возвращает true если поток активен
         isInterrupted - true если поток был прерван
         join() - ожидает завершение потока
         run() - точка входа в поток
         sleep()- приостанавливает выполнение потока, поток "засыпает"
         start() - запускает поток

         Создать поток можно двумя способами:

         1. Наследование от класса Thread
         */
//        System.out.println("Main thread started...");
//        MoltiDemo moltiDemo = new MoltiDemo("OurThread");
//        moltiDemo.start(); //  запускает метод run() в новом потоке
//       // System.out.println("Main thread finished");
//
//
//        MoltiDemo moltiDemo1 = new MoltiDemo("OurThread1");
//        moltiDemo1.start(); //  запускает метод run() в новом потоке
//        System.out.println("Main thread finished");
//
//        for (int i = 3; i < 10; i++) {
//            new MoltiDemo("OurThread " + i).start();
//
//        }

//        // 2. Создание потока через интерфейс Runnable
//
//        System.out.println("**********************");
//        System.out.println("Main thread started...");
//        OurThread ourThreadRunnable = new OurThread("FromRunnable1"); //  объект класса реализующий Ranable
//        Thread newThread = new Thread(ourThreadRunnable);
//        newThread.start();
//        for (int i = 0; i < 30; i++) {
//            System.out.println(".");
//            try {
//                Thread.sleep(100);
//            }catch (InterruptedException e){
//                System.out.println(e.getMessage());
//            }
//
//        }
//
//        System.out.println("Main thread finished");



//        Thread thread1 = new Thread(new OurRannable(),"Another Example");
//        thread1.start();

        // Определение момента окончания потока isAlive
//        System.out.println("Main thread started");
//        MoltiDemo moltiDemo1 = new MoltiDemo("Demo #1");
//        MoltiDemo moltiDemo2 = new MoltiDemo("Demo #2");
//        MoltiDemo moltiDemo3 = new MoltiDemo("Demo #3");
//        moltiDemo1.start();
//        moltiDemo2.start();
//        moltiDemo3.start();
//        do {
//            System.out.print(" . ");
//            try{
//                Thread.sleep(50);
//            }catch (InterruptedException e){
//                System.out.println(e.getMessage());
//            }
//        } while (moltiDemo1.isAlive() || moltiDemo2.isAlive() || moltiDemo3.isAlive());
//        System.out.println("main finished");

        // метод join() - заставляет поток ждать, пока поток на котором он вызван не закончит работу
        System.out.println("Main thread started");
        MoltiDemo moltiDemo1 = new MoltiDemo("Demo #1");
        MoltiDemo moltiDemo2 = new MoltiDemo("Demo #2");
        MoltiDemo moltiDemo3 = new MoltiDemo("Demo #3");
        moltiDemo1.start();
        moltiDemo2.start();
        moltiDemo3.start();

        System.out.print(" . ");
            try{
                Thread.sleep(50);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());

            }

            moltiDemo1.join();
            moltiDemo1.join();
            moltiDemo1.join();

        System.out.println("main finished");


    }


}
