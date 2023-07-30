import java.util.Arrays;
import java.util.Scanner;
/*
String is a collection of Characters which are enclosed in "" are called strings
ex:"abc","123"...
In Nothing String is treated as an object which object is present in java.lang package
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
* Mutable Strings --> The strings are which that can be changed this will be stored in
                      heap and we use append in place of concatenation and this will be
                      updated in same object rather created in new object
                  --> **The mutable string is created only using new Keyword
********** String Buffer and String Builder are used when we don't know how much length of string to be Created
           This are used only in case of Mutable Strings
           String Buffer --> Multithreading is not possible (synchronized)
                             only one thread can run at a time (Thread safe)
           String Builder -->Multithreading is possible (un synchronized)
                             Many Threads can run at a time
 */
public class _7_Strings_Buffer_Builder {
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

        //String Builder
        System.out.println("string builder");
        StringBuilder sb=new StringBuilder(); //the default capacity of string builder or string buffer is 16
        System.out.println(sb.capacity());//16
        sb.append("abcdefghijklmnop");//again added 16 bits to sb still it's capacity is 16 asa haven't given anything up
        System.out.println(sb.capacity());//16
        sb.append("s");//added another bit to it --> then it becomes (16+1)*2 space
        System.out.println(sb.capacity());//34
        System.out.println(sb.length());//usually it's length should be 17

        StringBuilder sb1=new StringBuilder("Mdsadiq"); //here we have initialized data first only
        System.out.println(sb1);//Mdsadiq
        System.out.println(sb1.capacity());//23-->7+16
        System.out.println(sb1.charAt(1));//in Mdsadiq --> 1 index is d
        sb1.setCharAt(1,'A');//replace d with A
        System.out.println(sb1);//MAsadiq

        StringBuilder sb2=new StringBuilder(150);//here we are giving capacity first only how many we should keep
        System.out.println(sb2.capacity());//150 capacity
        sb2.append("sadiq");
        System.out.println(sb2);//here 150 only sadiq is there
        sb2.trimToSize();//we are removing remaining 145 bits space
        System.out.println(sb2.capacity());//5 spaces are filled sadiq

        //String Buffer
        System.out.println("string buffer");
        StringBuffer sb5=new StringBuffer(); //the default capacity of string builder or string buffer is 16
        System.out.println(sb5.capacity());//16
        sb5.append("abcdefghijklmnop");//again added 16 bits to sb still it's capacity is 16 asa haven't given anything up
        System.out.println(sb5.capacity());//16
        sb5.append("s");//added another bit to it --> then it becomes (16+1)*2 space
        System.out.println(sb5.capacity());//34
        System.out.println(sb5.length());//usually it's length should be 17

        StringBuffer sb6=new StringBuffer("Mdsadiq"); //here we have initialized data first only
        System.out.println(sb6);//Mdsadiq
        System.out.println(sb6.capacity());//23-->7+16
        System.out.println(sb6.charAt(1));//in Mdsadiq --> 1 index is d
        sb6.setCharAt(1,'A');//replace d with A
        System.out.println(sb6);//MAsadiq

        StringBuffer sb7=new StringBuffer(150);//here we are giving capacity first only how many we should keep
        System.out.println(sb7.capacity());//150 capacity
        sb7.append("sadiq");
        System.out.println(sb7);//here 150 only sadiq is there
        sb7.trimToSize();//we are removing remaining 145 bits space
        System.out.println(sb7.capacity());//5 spaces are filled sadiq

        //Final Keyword In java
        System.out.println("Final keyword");
        // -->using final keyword
        final StringBuffer sb3=new StringBuffer("Md");
        sb3.append("Sadiq");
        System.out.println(sb3);
        /*sb=new StringBuffer("Mohammad");
        System.out.println(sb);*/ //-->this will give error as when we use final keyword we cannot rewrite the sb pointer, but we can add and form a new object for existing vector
        // -->without using final keyword
        StringBuffer sb4=new StringBuffer("Md");
        sb4.append("Sadiq");
        System.out.println(sb4);
        sb4=new StringBuffer("Mohammad");
        System.out.println(sb4);

        //Reversing A String
        System.out.println("Reversing a String");
        /*Scanner sc1=new Scanner(System.in);
        String e=sc1.nextLine();
        System.out.println(e.substring(-1));*/
        String e="Sadiq Md";
        String f=" ";
        for (int i=e.length()-1;i>=0;i--){
            f+=e.charAt(i);
        }
        System.out.println("Before reversing"+" "+e);
        System.out.println("After reversing"+" "+f);

        // swapping the Words of String
        System.out.println("swapping the Words of String");
        String g="Md Sadiq";
        String h="";
        String arr[]=g.split(" ");
        for (int i=arr.length-1;i>=0;i--){
            h=h+arr[i]+" ";
        }
        System.out.println("Before reversing"+" "+g);
        System.out.println("After reversing"+" "+h);

        //Palindrome In Nothing
        System.out.println("Palindrome");
        String k="abcba";
        String l="";
        for (int i=k.length()-1;i>=0;i--){
            l=l+k.charAt(i);
        }
        if(k.equals(l)){
            System.out.println("it is an palindrome");
        }
        else{
            System.out.println("it is not an palindrome");
        }

        //Anagram Program in java
        //Anagram means lets take word keep we can create a word called peek from the keep with using same number of letters these both are anagram to each other
        System.out.println("Anagram");
        String m1="School Master";
        String m2="The Classroom";
        m1=m1.trim(); //removing spaces
        m2=m2.trim(); //removing spaces
        m1=m1.toLowerCase(); //convert them into either one of the cases to compare
        m2=m2.toLowerCase(); //convert them into either one of the cases to compare
        char arr1[]=m1.toCharArray(); //this convert the string into an array
        char arr2[]=m2.toCharArray(); //this convert the string into an array
        Arrays.sort(arr1); //this sort array in alphabetical order
        Arrays.sort(arr2); //this sort array in alphabetical order
        if (Arrays.equals(arr1,arr2)){
            System.out.println("It is an anagram");
        }
        else{
            System.out.println("It is not an anagram");
        }

        //Pangram in Nothing
        // If a sentence has all the alphabets from a to z then it is called a pangram
        System.out.println("Pangram");
        String n1="The Quick Brown Fox Jumps Over Lazy Dog ";
        String n2="abcdefghijklmnopqrstuvwxyz";
        n1=n1.trim(); //removing spaces
        n1=n1.toLowerCase(); //convert them into either one of the cases to compare
        char[] arr3 =n1.toCharArray(); //this convert the string into an array
        char[] arr4 =n2.toCharArray(); //this convert the string into an array
        Arrays.sort(arr3); //this sort array in alphabetical order
        Arrays.sort(arr4); //this sort array in alphabetical order
        if (Arrays.equals(arr3,arr4)){
            System.out.println("It is an Pangram");
        }
        else{
            System.out.println("It is not an Pangram");
        }
    }
}
