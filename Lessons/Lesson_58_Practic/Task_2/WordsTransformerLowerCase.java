package Task_2;

public class WordsTransformerLowerCase extends WordsTransformer {
    @Override
    public boolean check(String str) {
        return str.length()==4;
    }

    @Override
    public String transform(String str) {
        return str.toLowerCase();
    }
}
