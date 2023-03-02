//The use of Interface is we can create a parent class and refer the other classes objects from the reference of parent class
//example:Someone created a car nowadays, many companies manufacture the cars but still we refer it as a car even of different companies
interface sampleinterface{
    void meth1();
    void meth2();
}

interface childsampleinterface extends sampleinterface{  //inheriting childsampleinterface from sampleinheritance
    void meth3();
    void meth4();
}

class mysampleclass implements childsampleinterface{ //creating an interface from mysampleclass

    public void meth1(){
        System.out.println("meth1 - inheritance");
    }

    public void meth2(){
        System.out.println("meth2 - inheritance");
    }

    public void meth3(){
        System.out.println("meth3 - inheritance");
    }

    public void meth4(){
        System.out.println("meth4 - inheritance");
    }
}
public class _43_Inheritance_in_Interfaces {
    public static void main(String[] args) {
        mysampleclass obj=new mysampleclass();
        obj.meth1();
        obj.meth2();
        obj.meth3();
        obj.meth4();
    }
}
