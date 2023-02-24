
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
public class _45_Inheritance_in_Interfaces {
    public static void main(String[] args) {
        mysampleclass obj=new mysampleclass();
        obj.meth1();
        obj.meth2();
        obj.meth3();
        obj.meth4();
    }
}
