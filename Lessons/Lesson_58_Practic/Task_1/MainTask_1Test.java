package Task_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static junit.framework.Assert.assertEquals;

class MainTask_1Test {

    Predicate<String> predicate3;
    Predicate<String> predicate4;
    Predicate<String> predicate5;

    Function<String, String> function3;
    Function<String, String> function4;
    Function<String, String> function5;


    @BeforeEach
    public void setUp() {
        predicate3 = s -> s.length() == 3;
        predicate4 = s -> s.length() == 4;
        predicate5 = s -> s.length() == 5;

        function3 = String::toUpperCase;
        function4 = String::toLowerCase;
        function5 = s -> s.replaceAll(s, "*****");
    }

    @Test
    public void test_transformString_Condition3() {
        String expected = "ICH wunsche Ihnen alles Gute !";
        String actual = "Ich wunsche Ihnen alles Gute !";

        assertEquals(expected, MainTask_1.transformString(actual, predicate3, function3));
    }

    @Test
    public void test_transformString_Condition4() {
        String expected = "Ich wunsche Ihnen alles gute !";
        String actual = "Ich wunsche Ihnen alles Gute !";

        assertEquals(expected, MainTask_1.transformString(actual, predicate4, function4));
    }

    @Test
    public void test_transformString_Condition5() {
        String expected = "Ich wunsche ***** ***** Gute !";
        String actual = "Ich wunsche Ihnen alles Gute !";

        assertEquals(expected, MainTask_1.transformString(actual, predicate5, function5));
    }
    @Test
    public void test_transformString_empty() {
        String expected = "";
        String actual = "";

        assertEquals(expected, MainTask_1.transformString(actual, predicate5, function5));
    }


}