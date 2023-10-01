package Task;

import org.junit.jupiter.api.Test;

import java.io.File;

import static Task.Main.langStr;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

@Test
    public void testSumOfValues(){
        assertEquals(15,Main.langStr(new File("example.txt")));
    }

}