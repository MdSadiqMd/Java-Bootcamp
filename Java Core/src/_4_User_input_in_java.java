import java.util.Scanner; //this is a class code which we import while using a dynamic memory allocation
//import java.util.*        -->this imports all the classes in the package
public class _4_User_input_in_java {
    public static void main(String[] args) {
        //java.util.Scanner sc=new java.util.Scanner(System.in); //-->this acts same as importing java.util.Scanner without writing the below whole line
        Scanner sc= new Scanner(System.in); //here we are initializing the that we are using the above import statement generally calling it
        System.out.println("enter number 1:");
        int a= sc.nextInt(); // here we are entering the integer dynamic memory capital I
        System.out.println("enter number 2:");
        float b=sc.nextFloat(); //here we are entering the float dynamic memory capital F
        float sum=a+b;
        System.out.println("the sum is:"+sum);
        System.out.println("enter string");
        String str =sc.nextLine(); // it is used to print the string if we not use Line word then only one letter will print
        if(str.isEmpty()){
            str=sc.nextLine();
        }
        System.out.println(str);
        //if we want to a string to integer,float,byte,long,double we use parse key word
        /*
        ex: i/p: "123"-->String
            o/p: 123 -->integer
            i/p: "sadiq"-->String
            o/p: error
         */
        System.out.println("write an integer String to convert into integer,Float,byte,long,Double");
        String str1=sc.nextLine();
        System.out.println(Integer.parseInt(str1));
        System.out.println(Float.parseFloat(str1));
        System.out.println(Byte.parseByte(str1));
        System.out.println(Long.parseLong(str1));
        System.out.println(Double.parseDouble(str1));
    }
}
