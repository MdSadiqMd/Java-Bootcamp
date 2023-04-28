import java.io.*;
public class _3_File_Writer {
    public static void main(String[] args) throws IOException {
        try {
            FileWriter fw = new FileWriter("_3_java.txt"); //will create and  perform write operation in file
            fw.write("sadiq");
            fw.write("\n");
            fw.write(123);//The ASCII value of 123 will be entered
            fw.write("\n");
            char ch[] = {'s', 'a', 'd', 'i', 'q'};
            fw.write(ch);
            fw.flush();//If we don't know do we will add other data in file later on or not so we use flush rather than closing it
            fw.close();//need to close the file writer
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
