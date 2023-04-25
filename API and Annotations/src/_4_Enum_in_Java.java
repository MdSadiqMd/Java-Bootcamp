/*
We use Enum to define a group of named constants
By enum we can define our own data type which can also come enumerated data types
we can create variables,Constructor and methods in Enum
 */
enum week{ //This will create variables from mon to sat
    mon,tue,wed,thu,fri,sat;
}
public class _4_Enum_in_Java {
    enum result{ //This will create variables pass,fail,nr
        pass,fail,nr;
        //Behind the scenes
        //public static final result pass=new result();
        //public static final result fail=new result();
        //public static final result nr=new result();
    }
    public static void main(String[] args) {
        week w=week.mon;
        System.out.println(w);

        result res=result.pass;
        System.out.println(res);

        int index=week.mon.ordinal(); //ordinal gives index of the inputs
        System.out.println(index);

        //Printing the values in array
        week wr[]=week.values();
        for (week w1:wr){
            System.out.println(w1+" : "+w1.ordinal());
        }

        //Switch case using enum
        result res1=result.pass;
        switch(res1){
            case pass:
                System.out.println("pass");
            break;
            case fail:
                System.out.println("fail");
            break;
            case nr:
                System.out.println("no result");
        }
    }
}
