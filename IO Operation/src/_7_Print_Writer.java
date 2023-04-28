import java.io.*;
/*
Print writer we can insert int type of data also rather inserting its corresponding ASCII value and decrease more syntax rather remembering syntax
 */
public class _7_Print_Writer {
    public static void main(String[] args) throws IOException {
        File dir=new File("_7_JAVA-PW");
        File file=new File (dir,"_7_java.txt");
        dir.mkdir();
        file.createNewFile();
        FileWriter fw=new FileWriter(file);
        PrintWriter pw=new PrintWriter(fw);
        pw.println("sadiq");
        pw.println(123);
        pw.println(123.45);
        pw.close();
    }
}
