import java.io.*;
/*
This Transient Keyword is used for selective serialization
for example,I want the user only use name and runs rather than age
it means runs will not participate in serialization and after Deserialization also we won't get value of age
 */
class Cricketer2 implements Serializable {
    String name;
    transient int age;
    int runs;
    public Cricketer2 (String name,int age,int runs){
        this.name=name;
        this.age=age;
        this.runs=runs;
    }
    public void disp(){
        System.out.println(name);;
        System.out.println(age);
        System.out.println(runs);
    }
}
public class _10_Transient {
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        FileInputStream fis=new FileInputStream("_4_java.txt");
        BufferedInputStream bos=new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bos);
        Cricketer1 cr=(Cricketer1) ois.readObject();
        cr.disp();
        ois.close();
    }
}
