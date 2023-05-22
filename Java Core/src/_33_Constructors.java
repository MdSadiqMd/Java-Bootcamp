//Constructor is created in place of setters to create the area in heap of the variable when the object is created
//Constructor purpose is to initialize the value whose name is same ass the class name
//*****Interview Question: here student obj=new student(); the student is a constructor and we haven't given any arguments so why we don't get any error
//**If we haven't created a constructor and run the program then JVM will create a default Zero argument constructor in background
/*ex: before constructor concept we are created object like
      student obj=new student(); --> here this is an constructor we haven't created a constructor then JVM automatically create a null argument empty constructor
*/
//Constructor Overloading --> Many Constructors with same name but different parameter such that we can choose which to execute when with respect to number of arguments refer method overloading
//Super();--> super keyword is present default in every constructor this used to call or interlink the constructor and the class of constructor
//This();--> this keyword should be written by the programmer this is used to call or interlink two constructors of same class
//this and super method will work only when they are in first line in constructor
//Copy Constructor Means:A copy constructor is a constructor that initializes an object through another object of same class
//Constructor Overloading is also an noticeable point
class men{
    private int age;
    private String name;

    //Constructor should be of same name class with no specifiers like private,public,...

    /*men(int age) {
        //super(); -->already default internally present
        this("Md",19);//--> this will execute the second constructor as this is referring to two variables if we remove the arguments in down obj
        this.age=age;
    }*/
    men(String name,int age) {
        this.age=age;
        this.name=name;
    }

    /*public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
public class _33_Constructors {
    public static void main(String[] args) {
        men obj=new men("sadiq",20); //we use constructor, so we give values in the argument at the time of object creation
        /*obj.setName("sadiq");
        obj.setAge(20);*/
        String name=obj.getName();
        System.out.println(name);
        int age=obj.getAge();
        System.out.println(age);
    }
}
