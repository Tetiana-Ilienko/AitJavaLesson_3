package Task_3;

public class TransforStar implements WordTransformer {
    @Override
    public boolean checkWord(String str) {
        return str.length()==5;
    }

    @Override
    public String transformWord(String str) {
        return "*****";
    }
}
