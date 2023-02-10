//creating a class
//syntax:class name()
//we cannot delete an object in java the object will be moved in garbage collector
/*In java
  class data --> method area --> static blocks/static variables/references
  object data --> heap area --> instance variables
  every memory will store in different stacks --> stack memory -->method calls local variables
  these will get store in PC registers(variable data will be stored) and native method stacks (value of variable will be stored)
 */
class employee{
    int id;        //attribute1
    String name;   //attribute2
    public void details(){     //creating a method (or) function inside a class
        System.out.println(id);
        System.out.println(name);  //refer line 21

    }
}

public class _22_Classes_in_java {
    public static void main(String[] args) {
        //we can create any number of objects in the class
        //object 1
        employee sadiq=new employee();  //here we are creating an object of an class
        sadiq.id=12;
        sadiq.name="Md.sadiq";
        System.out.println(sadiq.id);
        System.out.println(sadiq.name);
        sadiq.details();  //here we are replacing line 19,20 with this line 21
        //object 2
        employee akhil=new employee();
        akhil.id=15;
        akhil.name="Akhil";
        System.out.println(akhil.id);
        System.out.println(akhil.name);
        akhil.details();
    }
}
