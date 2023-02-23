//abstract means an assumption
//abstract class is used to make many variations of a single class
/*abstract class cannot have objects because it is not a class it's just a standard to crate other classes with different variations*/
//syntax - abstract class classname
abstract class parent{  //creating na abstract class
    public parent(){   //creating a constructor
        System.out.println("constructor of parent class");
    }
    public void hello(){  //creating a void constructor of name hello
        System.out.println("parent class - hello world");
    }
    abstract void greet(); //this abstract class used to make variations of this single class
    abstract void greet1(); //this abstract class used to make variations of this single class
}

class child extends parent{
    @Override
    public void greet(){   //this constructor used to make variations from inherited class
        System.out.println("child inherit class - hello world - 1");
    }
    @Override
    public void greet1(){   //this constructor used to make variations from inherited class
        System.out.println("child inherit class - hello world - 2");
    }
}
public class _32_Abstract_class_and_Methods {
    public static void main(String[] args) {
        //parent p =new parent();  //we cant do this as it is an abstract class -- error
        child c=new child();
    }
}
