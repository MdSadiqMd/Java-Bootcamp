//here in threading in output the output will come
// as it like it will take preference as it like
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

public class _60_Threading_in_Runnable_interface {
    public static void main(String[] args) {
        MythreadRunnable1 t1= new MythreadRunnable1();
        Thread class1 = new Thread(t1);
        MythreadRunnable2 t2= new MythreadRunnable2();
        Thread class2 = new Thread(t2);
        MythreadRunnable3 t3= new MythreadRunnable3();
        Thread class3 = new Thread(t3);
        MythreadRunnable4 t4= new MythreadRunnable4();
        Thread class4 = new Thread(t4);

        //if want to give priority to a thread that after executing if that thread i=only the other thread should run then we can use this priority
        //class4.setPriority(MythreadRunnable4.MAX_PRIORITY); -->this will print the number first
        //class1.setPriority(MythreadRunnable1.MIN_PRIORITY); -->this will print the number last

        class1.start();
        //here in this block we used join function which stops other to run until 1 had run and completed
       /*try{
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
