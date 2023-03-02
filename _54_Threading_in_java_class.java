//multithreading is making many tasks by a program at a time
/*
without threading:
     main() --> function1() --> function2() -->end
     here the process of function 1 happens if the process with main have completed
with threading:
     main()-->
     function1()-->    end
     function2()-->
     here the functions implement at a time
 */
/*
class thread{
    public thread(MythreadRunnable2 t2) {
    }

    public void run(){
        System.out.println("class thread");
    }
}

class Mythread extends thread{   //creating an Mythread class which extends thread class
    public Mythread() {
        super(t2);
    }
    @Override
    public void run(){
        while(true){
            System.out.println("Mythread");
            System.out.println("1");
        }
    }
}

class Mythread1 extends thread{  //creating an Mythread class which extends thread class
    public Mythread1() {
        super(t2);
    }
    @Override
    public void run(){
        while(true){
            System.out.println("Mythread1");
            System.out.println("2");
        }
    }

}

public class _40_Threading_in_java_class {
    public static void main(String[] args) {
        Mythread t1=new Mythread();
        Mythread1 t2=new Mythread1();
        t1.run(); //-->here it runs mythread class which extended by thread class
        t2.run(); //-->here it runs mythread1 class which extended by thread class
        //here in output it does both the works simultaneously
    }
}*/
