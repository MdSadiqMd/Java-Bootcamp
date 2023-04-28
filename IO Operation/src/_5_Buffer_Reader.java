import java.io.*;
public class _5_Buffer_Reader {
    public static void main(String[] args) throws IOException {
        File dir=new File("_5_JAVA-PW");
        File file=new File (dir,"_5_java.txt");
        dir.mkdir();
        file.createNewFile();
    }
}
