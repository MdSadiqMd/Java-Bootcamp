import java.io.*;

class Cricketer1 implements Serializable {
    private String name;
    private int age;
    private int runs;
    public Cricketer1 (String name,int age,int runs){
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
public class _9_DeSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Cricketer1 c=new Cricketer1("Virat",30,5000);
        c.disp();*/
        FileInputStream fis=new FileInputStream("_4_java.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Cricketer1 cr=(Cricketer1) ois.readObject();
        cr.disp();
        ois.close();
    }
}
