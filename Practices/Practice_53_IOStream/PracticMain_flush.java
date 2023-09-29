import java.io.FileWriter;
import java.io.IOException;

public class PracticMain_flush {

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("example.txt");

        String text = "Consultation";
        writer.write(text);

        writer.flush();// сбрасывает содержимое буфера вывода в поток
        // если не прописываем exception  в коде, а пробрасываем его наверх throws IOException
        // нужно закрывать поток или пользоваться методом flush()
    }
}
