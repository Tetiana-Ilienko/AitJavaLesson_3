package Task_2;

public class WordsTransformerToUpperCase extends WordsTransformer{
    @Override
    public boolean check(String str) {
        return str.length()==3;
    }

    @Override
    public String transform(String str) {
        return str.toUpperCase();
    }
}
