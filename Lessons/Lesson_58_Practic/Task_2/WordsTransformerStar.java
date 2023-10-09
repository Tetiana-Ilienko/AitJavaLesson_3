package Task_2;

public class WordsTransformerStar extends WordsTransformer {
    @Override
    public boolean check(String str) {
        return str.length()==5;
    }

    @Override
    public String transform(String str) {
        return "*****";
    }
}
