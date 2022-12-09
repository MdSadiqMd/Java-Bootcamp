import java.util.Scanner;
public class _7_Strings {
    public static void main(String[] args) {
        // strings re immutable we can change a copy but not the original one
        //different methods to print a string
        String name = new String("sadiq"); // 1st method
        System.out.println(name);


        String name2="sadiq";//second method
        System.out.println(name2);


        int a=4; //using format specifier use printf in print statement
        System.out.printf("printing by using format specifier %d :" , a); //printf
        float b=34.345467f;
        System.out.printf("using format specifier %f",b);//the value of b will be print use printf
        System.out.printf("using format specifier %.2f",b);//here %.2f means it will show only two digits after point
        System.out.printf("using format specifier %8.2f",b);//here %8.2 f means it will give 8 spaces before point and print only upto two digits after point


        Scanner sc =new Scanner (System.in);//give before entering a string dynamically
        String st =sc.next();//will print only one letter if a full sentence is given
        System.out.println(st);
        String st2 = sc.nextLine();//will print the whole line of input given
        System.out.println(st2);
    }
}
