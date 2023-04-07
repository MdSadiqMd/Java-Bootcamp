import java.util.*;
import java.util.Map.*;
class student{
    private String name;
    private int age;
    private String city;
    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String toString(){
        return name+" "+age+" "+city;
    }

    public student(String name,int age,String city){
        this.name=name;
        this.age=age;
        this.city=city;
    }
}
public class _5_HashMap {
    public static void main(String[] args) {
        student st=new student("sadiq",18,"Vijayawada");
        student st1=new student("Ravikant",18,"Srikakulam");
        student st2=new student("Prakash",20,"Machilipatnam");
        Map m=new HashMap();
        m.put(1,st);
        m.put(2,st1);
        m.put(3,st2);
        System.out.println(m); //It will return address rather than output
                               //Now we have return toString() Constructor ,so we get normal output
        Set s=m.entrySet();
        Iterator itr1=s.iterator();
        while(itr1.hasNext()){
            Map.Entry data=(Entry)itr1.next();
            System.out.println(data.getKey()+" : "+data.getValue());
        }
    }
}
