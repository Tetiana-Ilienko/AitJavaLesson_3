package Task_2;

import Task_1.MainTask_1;
import org.junit.jupiter.api.Test;

import static Task_2.MainTask_2.transformString1;
import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class MainTask_2Test {


String str = "Ich wunsche Ihnen alles Gute !";
String str1 = "Ich wunsche dir alle Gute !";


    @Test
    public void test_transformString_empty() {
        String expected = "";
        String actual = "";

        assertEquals(expected, transformString1(actual, new WordsTransformerToUpperCase()));
    }

    @Test
    public void test_transformString_UpperCase() {
        String expected = "ICH wunsche Ihnen alles Gute !";
        String actual = str;

        assertEquals(expected, transformString1(actual, new WordsTransformerToUpperCase()));
    }

    @Test
    public void test_transformString_lowerCase() {
        String expected = "Ich wunsche Ihnen alles gute !";
        String actual = str;

        assertEquals(expected, transformString1(actual, new WordsTransformerLowerCase()));
    }

    @Test
    public void test_transformString_Star() {
        String expected = "Ich wunsche ***** ***** Gute !";
        String actual = str;

        assertEquals(expected, transformString1(actual, new WordsTransformerStar()));
    }

    @Test
    public void test_transformString_Star_not_change() {
        String expected = str1;
        String actual = str1;

        assertEquals(expected, transformString1(actual, new WordsTransformerStar()));
    }

}