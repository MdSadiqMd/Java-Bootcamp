import java.io.*;
public class _4_File_Reader {
    public static void main(String[] args) {
        try{
            FileReader fr=new FileReader("_4_java.txt");
            int data=fr.read();
            while(data!=-1){
                System.out.println(data);
                data=fr.read();
            }
            fr.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
