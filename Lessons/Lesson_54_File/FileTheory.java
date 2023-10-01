import java.io.File;
import java.io.IOException;

public class FileTheory {

    /** класс File ****/
    /*
    File - это класс в Java, который предоставляет абстракцию для работы с файлами и каталогами на файловой системе.
    Он позволяет выполнять множество операций, таких как создание, чтение, запись, удаление файлов и каталогов, а
    также проверку их существования и многое другое.

    конструкторы:
    File (String путь к каталогу/файлу)  - Создание объекта File по указанному пути.
    File (String dir, String fileName) - Создание объекта File из родительского и дочернего путей.

    File dir1 = new File("C\\dirName")

    методы:

    boolean createNewFile() - создаст новый файл, соответствующий переданному в конструктор пути
    boolean delete()  - удаляет файл\каталог
    boolean exist() -  проверяет. существует ли такой файл
    boolean renameTo(File dest) - Переименование файла или каталога.

Чтение информации о файле:
    String getName() -  возврашает имя файла или каталога
    String getPath() - Получение пути к файлу или каталогу.
    String getAbsolutePath() -  возвращает абсолютный путь к файлу

    boolean isDirectory() - true, если это каталог
    boolean isFile() - true,   если это файл
    boolean mkdir() - Создание каталога.

    long Length() - Получение размера файла (в байтах).
    long lastModified() - Получение времени последнего изменения файла (в миллисекундах с 1 января 1970 года).

Операции над файлами и каталогами:
    String[] list() - Получение массива имен файлов и каталогов в данном каталоге.
    File[] listFiles() - Получение массива объектов File для файлов и каталогов в данном каталоге.

Специфичные операции для каталогов:
    File[] listFiles(FilenameFilter filter) - Получение массива файлов, отфильтрованных по имени.
    File[] listFiles(FileFilter filter) - Получение массива файлов, отфильтрованных с использованием пользовательского фильтра.

Создание временных файлов:
    static File createTempFile(String prefix, String suffix) - Создание временного файла.

Работа с путями:
    static File[] listRoots() - Получение массива корневых путей (дисковых устройств).
    File getParentFile() - Получение объекта File для родительского каталога.

     */
    public static void main(String[] args) throws IOException {

        File file = new File("example.txt");
        System.out.println("File name: " + file.getName()); // File name: example.txt

        System.out.println(file.isFile()); // true

        System.out.println(file.length());// 40

        File file1 = new File("fileExample.txt");
        System.out.println(file1.createNewFile()); // true

        System.out.println(file1.getAbsolutePath());// C:\AIT\Idea\AitJavaLesson_3\fileExample.txt


    }


}


