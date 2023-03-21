//we cannot access non-static variable in a static method, but we can access static variable in a non-static method
class student{
    int age;
    String school;
    public void show(){
        System.out.println("show obj without static"+" "+age);
        System.out.println("show obj without static"+" "+school);
    }
}
class student1{
    int age1;//not given static keyword so,it is instance variable and non-static variable
    static String school1;//non-instance variable and static variable
    public void show1(){
        System.out.println("show obj with static"+" "+age1);
        System.out.println("show obj with static"+" "+school1);
    }
}
class student2{
    int age2;//not given static keyword so,it is instance variable and non-static variable
    static String school2;//non-instance variable and static variable
    public static void show3(){
        //System.out.println("show obj with static"+" "+age2); //we cant access this age because refer line1
        System.out.println("show obj with static"+" "+school2);
    }
}
class student3{
    int age3;
    static String school3;
    //we have a special keyword loop called static keyword loop which we can initialize the values in it
    static{
        school3="Md";
    }
    public static void show4(){
        //System.out.println("show obj with static"+" "+age3); //we cant access this age because refer line1
        System.out.println("show obj with static"+" "+school3);
    }
}

public class _24_Static_Keyword {
    public static void main(String[] args) {
        //show();--> we can't access it directly only by using object we can access

        System.out.println();//just written for space that's it
        //Creating objects with the value of age
        student obj=new student();
        obj.age=19;
        obj.school="sadiq";
        obj.show();//19,sadiq

        //creating object without the value of age
        student obj1=new student();
        obj1.show();//0,null

        System.out.println( );
        System.out.println("here in static keyword the value assigned will be changed for all objects if we use static keyword");
        //Creating objects with the value of age
        student1 obj2=new student1();
        obj2.age1=19;
        obj2.school1="sadiq";
        obj2.show1();//19,sadiq

        //creating object without the value of age
        student1 obj3=new student1();
        obj3.show1();//0,sadiq

        System.out.println();
        System.out.println("creating main method using static keyword");
        //creating objects with the value of age
        student2 obj4=new student2();
        obj4.age2=19;
        obj4.school2="sadiq";
        obj4.show3();//sadiq--> cannot access int age refer line1

        //creating object without the value of age
        student2 obj5=new student2();
        obj5.show3();//sadiq--> cannot access int age refer line1

        System.out.println();
        System.out.println("Printing values using static loop");
        //Creating objects with the value of age
        student3 obj6=new student3();
        obj6.age3=19;
        obj6.school3="sadiq";
        obj6.show4();

        //creating object without the value of age
        student3 obj7=new student3();
        obj7.show4();
    }
    static{
        System.out.println("****static block --> written below main class"); //this will execute before the main class because it will execute at the time of class compilation
    }
}
