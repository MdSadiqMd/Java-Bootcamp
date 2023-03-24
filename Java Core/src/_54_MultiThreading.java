/*
There are some states of threads in java
                                                                                                               <--------------------------------------------------------------------------------------------------------------------------------------------------------
                                                                                                               |                  It happens when the thread execution encounters the yield() method                                                                   |                                                                 |
                                                                                                               |                                                                                                                                                       |
New thread(The thread which is just now created) ------> (By using t1.start();) -----> Runnable / Ready state (and here thread will be handled over the thread scheduler ) -----> (After getting permission and allocation from the thread scheduler) -----> Running state ------>Dead State ( after completion of the whole thread come to dead state)
                                                                                                                                                                                                                                                                     |
                                                                                                                                                                                                                                                                     |
                                                                                                                                                                                                                                                                     |                 (or)Dead State refer 59(Dead lock)
                                                                                                                                                                                                                                                                      ---> This runnable state can be redirected to waiting or blocked state if it encounters the sleep method and go to runnable method
*/
/*
How Threading Works ****Without Runnable Interface Acting Directly (refer 55)? --> There is an Interface called Runnable Interface Which has void run(); Function which is public and abstract
                     --> There is an inbuilt class by the name thread class in which many methods like join(),run(),sleep(),....
                     --> When we creating a class we write thread-name extends thread which activate the thread class which inherit thread methods to the created thread
                     --> We should not call run method we should call start method for output (t.start()) by which it hands over the thread to thread scheduler and if we call run then it will act as single thread program neglecting the default main thread
                     Summary : Runnable Interface(public and Abstract) <-- Thread Class( which haves join(),Run(),sleep(),... Methods) <-- Extended by the thread we create
There are two ways to create Threads
1.By Extending Thread Class
2.By Implementing Runnable Interface
 */
class Mythread extends Thread{
    public void run(){
        System.out.println("Child Thread");
    }
}
public class _54_MultiThreading {
    public static void main(String[] args) {
        System.out.println("Main Thread");
        Mythread t=new Mythread();
        t.start();
    }
}
