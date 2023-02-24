//method Overriding - let us say we created a class A and inherit it in class B if we call
                    //the value of B then the latest value of A will print
//***If we are not writing anything into inherited child class then the class is called Inherited class or Inherited method
//if we write anything into the inherited class then it become override class
//if we write a method in inherited class that is not present in parent class then that is called specialized class
//here only overriding example is only written below
//When we are overriding the access modifier and number of arguments should be same as parent class
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
    @Override
    public void meth2(){
        System.out.println("meth 2 constructor of class B");
    }
    public void meth3(){
        System.out.println(" meth 3 constructor of inherit classB");
    }
}
public class _36_Method_Overriding {
    public static void main(String[] args) {
        A a=new A();
        a.meth2();
        B b=new B();
        b.meth2();
    }
}
