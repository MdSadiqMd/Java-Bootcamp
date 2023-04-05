/* table that depicts that can we use the access modifiers in same class or same subclass or same package it will give output or not

modifier     class    package    subclass   other_than_these

public       yes      yes        yes        yes
protected    yes      yes        yes        no
default      yes      yes        no         no
private      yes      no         no         no
 */
//*****Even if we write Static Public void main it will Run Correctly

//example of same class
class c1{
    public int x=5;
    protected int y=45;
    int z=6;
    private int a=78;
    public void meth1(){
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(a);
    }
}

public class _29_Access_modifiers_in_java {
    public static void main(String[] args) {
        c1 c =new c1();
        c.meth1();
    }
}
