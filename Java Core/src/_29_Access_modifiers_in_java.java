/* table that depicts that can we use the access modifiers in same class or same subclass or same package it will give output or not

modifier     class    package    subclass   other_than_these

public       yes      yes        yes        yes
protected    yes      yes        yes        no
default      yes      yes        no         no
private      yes      no         no         no
 */
//*****Even if we write Static Public void main it will Run Correctly

/*
***Difference Between Final , Finally and Finalize Methods
Final --> It is a Modifier Applicable for Classes,methods and variables
          If a class declared Final then we can't extend the class i.e., we can't create child class for it
          If a method declared final we can't override that method in child class
          If a variable declared Final then it will become constant ,and we can't re-assign value for that variable
Finally --> Finally is a block with try,catch blocks which is generally used to write clean up code like clear database connection etc....
Finalize --> It is a method which is called by the garbage collector before destroying an object to remove if there are any connections like database connections associated with the variable
*
* Note: Finalize is for clean up activity of variable and Finally is for cleanup activity of try block
 */

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
