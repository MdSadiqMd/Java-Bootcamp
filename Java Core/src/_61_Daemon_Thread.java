/*
Daemon Thread is a service thread which provides service to NOn-Daemon Thread
Daemon Thread is a service provider thread that provide services to user thread
Daemon thread depends upon the user thread is all threads execution completed then the JVM will terminate the Daemon thread Automatically
ex:Garbage collector(which clear the unused data in background),Spelling Checker in intellij IDE
 */
//here in program we are creating a loop that check whether a thread is daemon or not as daemon thread work in background only we make a thread in daemon thread to ****to understand the concept
//***If we are declaring a thread into Daemon thread to understand the concept we should do it before start() method otherwise it throws an exception
//***we cannot make main thread into Daemon Thread
class test1 extends Thread{
    public void run(){
        if(Thread.currentThread().isDaemon()){
            System.out.println("Daemon Thread");
        }
        else{
            System.out.println(Thread.currentThread().getName());
        }
    }
}
public class _61_Daemon_Thread {
    public static void main(String[] args) {
        test1 t1=new test1();
        test1 t2=new test1();
        test1 t3=new test1();
        t1.setDaemon(true);//It sets the thread into a Daemon Thread --> syntax:t1.setDaemon(boolean b)
        t1.start();
        t2.start();
        t3.start();
    }
}
