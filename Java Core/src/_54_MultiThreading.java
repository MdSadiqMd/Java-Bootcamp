//The Statements which we want to run With separate type of execution or Different thread other than main thread we keep them inside public void run()
//Here the main thread execute first and then when we tell t1.start() and t2.start() then the threads t1 and t2 will be handover to thread scheduler and the thread scheduler will run them as per it's convenience on the consideration of the metric that CPU time should not be wasted
//What do I mean in the Above Statement? --> for example the Zoom and WhattsApp threads are running then first Zoom thread will run and later on if any Interruptions occur in zoom thread then the thread scheduler will skip the execution to Whattsapp thread as the interuption wastes the CPU time
//Now let us take an example that lets sleep zoom thread for some time and ******keep that in try catch block to avoid the compiler error as sleeping is an interruption the execution changes to Whattsapp block

class Zoom extends Thread{
    public void run(){
        System.out.println("Meeting is Going");
        System.out.println("Meeting is Going");
        System.out.println("Meeting is Going");
        System.out.println("Meeting is Going");
        try{
            Thread.sleep(2000);//It means two seconds the standard time consideration in java is milliseconds
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Meeting is Going");
        System.out.println("Meeting is Going");
        System.out.println("Meeting is Going");
        System.out.println("Meeting is Going");
        System.out.println("Meeting is Going");
        System.out.println("Meeting is Going");
    }
}
class WhattsApp extends Thread{
    public void run(){
        System.out.println("Replying to messages");
        System.out.println("Replying to messages");
        System.out.println("Replying to messages");
        System.out.println("Replying to messages");
        System.out.println("Replying to messages");
        System.out.println("Replying to messages");
    }
}
public class _54_MultiThreading {
    public static void main(String[] args) {
        Zoom t1=new Zoom();
        WhattsApp t2=new WhattsApp();
        t1.start();
        t2.start();
    }
}
