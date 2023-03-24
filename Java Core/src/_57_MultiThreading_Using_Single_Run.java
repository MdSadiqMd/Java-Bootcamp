//Here we are using only a single run method by redirecting the output of threads using if else blocks
class thread extends Thread {
    public void run(){
        String Name=Thread.currentThread().getName();
        if (Name.equals("Zoom")){
            Zoom();
        }
        else{
            whattsapp();
        }
    }
    public void Zoom(){
        System.out.println("Meeting");
        System.out.println("Meeting");
        System.out.println("Meeting");
        System.out.println("Meeting");
        System.out.println("Meeting");
    }
    public void whattsapp(){
        System.out.println("Replying");
        System.out.println("Replying");
        System.out.println("Replying");
        System.out.println("Replying");
        System.out.println("Replying");
    }
}
public class _57_MultiThreading_Using_Single_Run {
    public static void main(String[] args) {
        thread t1=new thread();
        thread t2=new thread();
        t1.start();
        t2.start();
    }
}
