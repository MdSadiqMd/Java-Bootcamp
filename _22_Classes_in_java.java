//creating a class
//syntax:class name()
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
        //we can creating any number of objects in the class
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
