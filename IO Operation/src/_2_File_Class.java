import java.io.*;
public class _2_File_Class {
    public static void main(String[] args) throws IOException {
        File dir=new File("_2_JAVA-PW");
        //(or)
        /*String s="_2_JAVA-PW";
        File dir=new File(s);*/
        System.out.println(dir.isDirectory());
        dir.mkdir();
        File file=new File(dir,"_2_java.txt");//This will create a _2_java file and put it into _2_JAVA-PW Folder
        file.createNewFile();
        System.out.println(file.isFile());

        //Printing number of Files in the Directory
        int count=0;
        String str[]=file.list();
        for(String name:str){
            count++;
            System.out.println(name);
        }
        System.out.println("Number of Files"+count);
    }
}
