/*
How Threading Works? --> There is an Interface called Runnable Interface Which has void run(); Function which is public and abstract
                     --> There is an inbuilt class by the name thread class in which many methods like join(),run(),sleep(),....
                     --> When we creating a class we write thread-name extends thread which activate the thread class which inherit thread methods to the created thread
                     --> We should not call run method we should call start method for output (t.start()) by which it hands over the thread to thread scheduler and if we call run then it will act as single thread program neglecting the default main thread
There are two ways to create Threads
1.By Extending Thread Class
2.By Implementing Runnable Interface
 */
class Mythread extends Thread{
    public void run(){
        System.out.println("Child Thread");
    }
}
public class _53_MultiThreading {
    public static void main(String[] args) {
        System.out.println("Main Thread");
        Mythread t=new Mythread();
        t.start();
    }
}
