package Practice;

public class LazyInspiredClerk extends AbstractClerk{

    private static int INSPIRATION_PROBABILITY = 20; //  вероятность вдохновения
    private static int INSPIRATION_TIMES = 3;// сколько раз выдает кредиты быстрее

    private double inspirationCoef;

    public LazyInspiredClerk(String name, int minTime, int maxTime, int creditsNum,double inspirationCoef) {
        super(name, minTime, maxTime, creditsNum);
        this.inspirationCoef = inspirationCoef;

    }


    @Override
    public void run() {

    }
}
