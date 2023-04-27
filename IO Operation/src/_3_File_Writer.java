import java.io.*;
public class _3_File_Writer {
    public static void main(String[] args) throws IOException {
        File dir=new File("_3_JAVA-PW");
        File file=new File(dir,"_3_java.txt");
        FileWriter fw=new FileWriter(file); //we perform write operation in file
        fw.write("sadiq");
        fw.write(123);//The ASCII value of 123 will be entered
        char[] ch ={'s','a','d','i','q'};
        fw.write(ch);
        fw.close();//need to close the file writer
    }
}
