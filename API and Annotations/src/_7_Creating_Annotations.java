/*
To create Annotations we need to use Interfaces with @
we use @Interface to create a new Annotations
 */
import java.lang.annotation.*;

//Creating Annotation
//@Target(ElementType.TYPE)//This shows where we are going to use this annotation method,class,constructor,........
@Target( {ElementType.TYPE,ElementType.METHOD,ElementType.FIELD} )//If we want to apply for more
@Retention(RetentionPolicy.RUNTIME) //This shows that the annotation we had given is going to be valid till runtime
@interface player{
    String country() default "India"; //Here we give default value if we don't want to specify the parameters in annotation
    int age() default 34; //there should be only one semicolon
}

//Using Annotation
@player(country="India",age=34)
class Virat{
    private int innings;
    private int runs;
    public int getInnings(){
        return innings;
    }
    public void setInnings(int innings){
        this.innings=innings;
    }
    public int getRuns(){
        return runs;
    }
    public void setRuns(int runs){
        this.runs=runs;
    }
}
public class _7_Creating_Annotations {
    public static void main(String[] args) {
        Virat v=new Virat();
        v.setInnings(300);
        v.setRuns(20000);
        System.out.println(v.getInnings());
        System.out.println(v.getRuns());

        //Using created Annotation
        Class c=v.getClass();
        Annotation a=c.getAnnotation(player.class); //Storing annotation functionality in "a" variable
        player cp=(player) a;
        int age=cp.age();
        System.out.println(age);
        String country=cp.country();
        System.out.println(country);
    }
}
