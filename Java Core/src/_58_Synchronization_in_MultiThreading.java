/*
Here Synchronized keyword will make the thread scheduler to run one thread after other rather than all threads using one main thread at a time to run
synchronized(this) this one is used if we want to give the resources present in a block to each thread at a time rather than resource to all threads at a time
 */
class rapido extends Thread{
    //public void run(){
     synchronized public void run(){
        try{
            System.out.println(Thread.currentThread().getName()+"1st");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+"2nd");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+"3rd");
            Thread.sleep(2000);
            synchronized (this){
                System.out.println(Thread.currentThread().getName()+"4th");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"5th");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"6th");
                Thread.sleep(2000);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
public class _58_Synchronization_in_MultiThreading {
    public static void main(String[] args) {
        rapido r=new rapido();
        Thread t1=new Thread(r);
        Thread t2=new Thread(r);
        Thread t3=new Thread(r);
        t1.setName("Thread 1-");
        t2.setName("Thread 2-");
        t3.setName("Thread 3-");
        t1.start();
        t2.start();
        t3.start();
    }
}
