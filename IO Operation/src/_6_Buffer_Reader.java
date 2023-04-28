import java.io.*;
public class _6_Buffer_Reader {
    public static void main(String[] args) throws IOException {
        File dir=new File("_6_JAVA-PW");
        File file=new File (dir,"_6_java.txt");
        dir.mkdir();
        file.createNewFile();
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        String line=br.readLine();
        while(line!=null){
            System.out.println(line);
            line=br.readLine();
        }
    }
}
