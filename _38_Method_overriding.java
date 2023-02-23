//method Overriding - let us say we created a class A and inherit it in class B if we call
                    //the value of B then the latest value of A will print
class A{
    public int a;
    public int harry(){
        return 4;
    }
    public void meth2(){
        System.out.println("meth 2 constructor of class A");
    }
}
class B extends A{
    @Override    //
    public void meth2(){
        System.out.println("meth 2 constructor of class B");
    }
    public void meth3(){
        System.out.println(" meth 3 constructor of inherit classB");
    }
}
public class _38_Method_overriding {
    public static void main(String[] args) {
        A a=new A();
        a.meth2();
        B b=new B();
        b.meth2();
    }
}
