/*
This Deals with the Mechanism of Class Inside a Class
The Use of It is there will  be some classes when we want to use them specifically for a class
In that case we can create a class Inside that class rather creating it else where
 */
class a{
    public void show(){
        System.out.println("In show");
    }
    class b{
        public void display(){
            System.out.println("In display");
        }
    }
}
public class _47_Inner_Class {
    public static void main(String[] args) {
        //creating obj of a
        a obj=new a();
        obj.show();//In show
        //obj.display(); --> error as we cannot access the obj of other class from reference of other class
        //creating obj separately for class b
        /*b obj1=new b();
        obj1.display();*/ //--> still we cannot access this as it is inside a ,and we need to get permission of a
        a.b obj1=obj.new b();
        obj1.display();
    }
}
