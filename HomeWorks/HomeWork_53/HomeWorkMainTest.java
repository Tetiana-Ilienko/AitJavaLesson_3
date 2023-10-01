import org.junit.jupiter.api.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

class HomeWorkMainTest {
    @Test
  public  void testReadFile () throws IOException {
        StringBuilder sb = new StringBuilder();
        sb = sb.append("Consultation").append("\n")
                .append("Hallo Java!").append("\n")
                .append("Guten Morgen!").append("\n");
        String expected = new String(sb);


    assertEquals(expected, HomeWorkMain.readFile("example.txt"));
  }



}