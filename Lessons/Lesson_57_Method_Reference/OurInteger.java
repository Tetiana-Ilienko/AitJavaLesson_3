public class OurInteger {
    private int val;

    public OurInteger(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public boolean isFactor(int n){
        return (val % n ==0);
    }
}
