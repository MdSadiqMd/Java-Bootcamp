import java.io.*;
/*
For Writing and Reading the data we have Buffer writer and reader and Print Writer
But to store videos,Audios on to a file and making them persistent(storing permanently) we use Input Output Streams
In serialization our main objective is security we store byte code in RAM that makes and to retrieve in normal form we use Deserialization
The converted Bytes to transfer to a file we have FileOutput Stream
To make data into sequence of bytes we use object output Stream
To make the process more efficient and faster we have Buffer Output Stream and Buffer Input Stream
To Reconstruct back the data of bytes we use Object Input Stream and File Input Stream
 */
class Cricketer implements Serializable{
    private String name;
    private int age;
    private int runs;
    public Cricketer (String name,int age,int runs){
        this.name=name;
        this.age=age;
        this.runs=runs;
    }
}
public class _8_Serialization {
    public static void main(String[] args) throws IOException {
        Cricketer c=new Cricketer("virat",30,50000);
        FileOutputStream fos=new FileOutputStream("_4_java.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fos);//this line makes code faster we can remove it if we want
        ObjectOutputStream oos=new ObjectOutputStream(bos);//if we remove the above line replace bos with fos
        oos.writeObject(c);//This c is converted into byte code which is not understandable by normal people and enhancing the security of the data of the code
        oos.flush();
        oos.close();
    }
}
