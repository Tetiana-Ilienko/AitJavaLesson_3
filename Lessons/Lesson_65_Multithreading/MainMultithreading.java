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
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());


    }


}
