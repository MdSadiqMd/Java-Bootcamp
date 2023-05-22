/*
// Shadowing Means defining two variables with name in scope which overlaps
Here we have two classes --> human1,_45_THis_Keyword_shadowing
human1 class have three methods --> data1,data2,show
_33_This_Keyword_shadowing class have two objects obj1,obj2
Here we are giving values from _33_This_Keyword_shadowing class objects to the dynamic variables present in methods data 1,data2
 */
class human1{
    private int age;
    private String name;
    public void data1(int age){
        //age=age; --> here the age =age the JVM or IDLE don't know which is instance variable and which is local variable,
        //             so we use this keyword which specify this.age that age is an instance variable
        this.age=age;
    }
    public void data2(String name){
        //name="sadiq";
        this.name=name;
    }
    public void show(){
        System.out.println(age+" "+name);
    }
}
public class _32_This_Keyword_shadowing {
    public static void main(String[] args) {
        human1 obj1=new human1();
        human1 obj2=new human1();
        obj1.data1(18);
        obj2.data1(19);
        obj1.data2("md");
        obj2.data2("MD");
        obj1.show();
        obj2.show();
    }
}
