/*
In Java when we create an object it is created in RAM and RAM is volatile in nature the data stored in RAM is not permanent it may erase
SO to store data permanently we have two options
1.To store in database
2.To store in hard Disk
The IO operation is used to store data in hard disk suing java.io package
 */
import java.io.*;
public class _1_File_Class {
    public static void main(String[] args) throws IOException{
        File file=new File("_1_java.txt"); //Here if the Overall Folder we are working has the file called java.txt then it will point to that file otherwise it will create an object called java.txt and point to it
        System.out.println(file.exists());
        file.createNewFile(); //This creates a new File in the overall Folder
                              // This line may throw an exception, so we handle it using IO exception
        System.out.println(file.exists());

        //Doing the same with a Directory as of file at top
        File dir=new File("_1_JAVA-PW");
        System.out.println(dir.exists());
        dir.mkdir();
        System.out.println(dir.exists());
    }
}
