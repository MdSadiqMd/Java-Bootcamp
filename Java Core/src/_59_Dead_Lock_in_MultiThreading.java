class library implements Runnable{
    String book1=new String ("java");
    String book2=new String ("SQL");
    String book3=new String ("Spring");
    public void run() {

    }
}
public class _59_Dead_Lock_in_MultiThreading {
    public static void main(String[] args) {
            library lb=new library();
            Thread t1=new Thread(lb);
            Thread t2=new Thread(lb);
    }
}
