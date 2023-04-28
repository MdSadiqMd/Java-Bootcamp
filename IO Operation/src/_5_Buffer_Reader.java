import java.io.*;
/*
Buffer Writer Enchances File Writer with less code and Faster execution
 */
public class _5_Buffer_Reader {
    public static void main(String[] args) throws IOException {
        File dir=new File("_5_JAVA-PW");
        File file=new File (dir,"_5_java.txt");
        dir.mkdir();
        file.createNewFile();
        FileWriter fw=new FileWriter(file);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write("Allah");
        bw.newLine();
        bw.write(12);
        char ch[]={'a'};
        bw.close();
    }
}
