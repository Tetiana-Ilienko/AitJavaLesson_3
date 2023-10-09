package Task_3;

public class TransforToLowCase implements WordTransformer{
    @Override
    public boolean checkWord(String str) {
        return str.length()==4;
    }

    @Override
    public String transformWord(String str) {
        return str.toLowerCase();
    }
}
