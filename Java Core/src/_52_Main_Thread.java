/*
Any task that should execute in computer the task is moved to RAM and the task will be done by Processor as per instructions of RAM
In out Devices we can Operate multiple things at a time ex:we can reply to WhatsApp message in between Zoom meeting
Here on device OS system is used for Context switching ,means it switch between many things at a time
There are two types in Multitasking that are
1.Process based Multitasking --> Executing Several tasks Simultaneously where each task is a separate Independent ***Process.Here the tasking is carried by OS(Windows)
2.Thread Based Multitasking --> Executing Several tasks Simultaneously where each task is a separate Independent part of the ***Same Program,where each independent part is called a "Thread"
***The Main Thread is Default Created Behind by JVM
 */
public class _52_Main_Thread {
    public static void main(String[] args) {
        System.out.println("Main thread");
        String name=Thread.currentThread().getName(); //This Will give the name of the thread
                                                     //This one statement shows that there will be a default inbuilt thread in java
        System.out.println(name);
    }
}
