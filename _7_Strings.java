import java.util.Scanner;
/*
String is a collection of Characters which are enclosed in "" are called strings
ex:"abc","123"...
In Java String is treated as an object which object is present in java.lang package
memory is allocated in heap area
We use an in build class to create string in java called String
ex: 1.String name ="abcd";
    2.String name=new String ("abcd");
    3.char ch[]={"a","b","c"}
      String name=new String(ch)
here lets discuss memory allocation of string in different types of execution
* In first method when we create string without using new keyword then the String
  will be stored in "String constant pool" which is present in Heap area of a
  pointer pointing it
  Here when we create a duplicate element then the another pointer will be created
  and point to same already created string
  p1--> string <--p2 //duplicates are not permitted
  ex: string s1="sadiq";
      string s2="sadiq";
      print(s1==s2) //o/p:true as the same string is referred by two pointers
* In second and third method when we create the String data using new keyword then
  the memory will be stored in Heap area with a pointer and a copy of the string
  will be stored in "string constant pool also but without any pointer pointing it
  Here when we create a duplicate element then the another pointer will be created
  and point to the duplicate string
  p1--> string
  p2-->string //duplicates are permitted
  ex:string s1=new string("sadiq");
     string s2=new string("sadiq");
     print(s1==s2) //o/p:false as the string is referred by different pointers
*If we use .equals method then it will compare content of strings rather then pointers
 */
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
