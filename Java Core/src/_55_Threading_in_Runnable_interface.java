/*
Here as we Knew before that Thread class will Inherit the Runnable Interface and Mythread will inherit thread Interface but here when we use Runnable interface the Mythread class will directly Inherit from Runnable Interface rather thread class in between
Summary: Without Runnable Interface Acting Directly
         Summary : Runnable Interface(public and Abstract) <-- Thread Class( which haves join(),Run(),sleep(),... Methods) <-- Extended by the thread we create
         With Runnable Interface Acting Directly
         Summary : Runnable Interface(public and Abstract) <-- Extended by the thread we create
WHen we are using Runnable Directly we Use Implements runnable keyword After the Created Thread Name
Using Runnable Interface Directly is More preferable as we can Extend and Implement many threads, but we can extend only one class
The run Method is available in the thread class constructed Using a separate runnable object.Otherwise, this Method does nothing and returns.we can also run it multiple times
 */
class MythreadRunnable1 implements Runnable {
    public void run() {
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
        System.out.println("thread 1");
    }
}

class MythreadRunnable2 implements Runnable{
    public void run(){
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
        System.out.println("thread 2");
    }
}
class MythreadRunnable3 implements Runnable{
    public void run() {
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
        System.out.println("thread 3");
    }
}
class MythreadRunnable4 implements Runnable{
    public void run() {
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
        System.out.println("thread 4");
    }
}

public class _55_Threading_in_Runnable_interface {
    public static void main(String[] args) {
        MythreadRunnable1 t1= new MythreadRunnable1();
        Thread class1 = new Thread(t1);
        MythreadRunnable2 t2= new MythreadRunnable2();
        Thread class2 = new Thread(t2);
        MythreadRunnable3 t3= new MythreadRunnable3();
        Thread class3 = new Thread(t3);
        MythreadRunnable4 t4= new MythreadRunnable4();
        Thread class4 = new Thread(t4);

        //If we want to give priority to a thread that after executing if that thread i only the other thread should run then we can use this priority
        //class4.setPriority(MythreadRunnable4.MAX_PRIORITY); //-->this will print the number first
        //class1.setPriority(MythreadRunnable1.MIN_PRIORITY); //-->this will print the number last

        class1.start();
        //here in this block we used join function which stops other to run until 1 had run and completed
       /*
       try{
          class1.join();
        }
        catch(Exception e){
            System.out.println(e);
        }*/
        class2.start();
        class3.start();
        class4.start();
    }
}
