/*
JIT --> just in time Compiler It increases efficiency of Interpreter by compiling the byte code in the run time.JIT compiles code to Machine Level Directly for higher speeds of code execution

Class Loader --> It is a subsystem of JVM dedicated to load class files when a program is executed ,Class Loader is the first one to load the executable File

Association --> It is a relationship that has no ownership over another ex: A person may have many bank accounts but each bank account is not have any relationship with another

Java is Not Completely OOP Language because it still makes use of eight or more primitive data types 100% object-oriented means everything must be object-oriented but primitive declaration of data types is not made by objects

Wrapper Class--> When we create Data types in java then the wrapper classes are responsible for converting them into objects

***We cannot Implement Pointers in java as JVM takes care of memory management implicitly

***If we not Declare main method as static in java then Program may compile ,but it will return a Run time error

JDK is a combined package of JRE used to design java applications an applets there are three variants of these 1.JDK standard Edition --> people,2.JDK Enterprise Edition --> professionals,3.JDK Micro Edition--> Companies

We cannot overload a static method

Late Binding --> Binding is a process of unifying the method call with the method's code segment.Late Binding happens when the method's code segment is unknown till the method is called during the run time

>> it will right shift,>>> will shift out the Zeroes

static type means we need to specify the type of Variable ex:java
ex: int a=10;
    a="sadiq"; o/p:error
In Dynamically typed language means we don't need to specify the type of the variable ex:python
ex: a=10
    a="sadiq" o/p:sadiq

If No pointer is pointed to an Object then it goes to Garbage Collector Automatically to call garbage collector we use System.gc();

Here variable a,main method main,... are Identifiers and the values are Literals

.class file --> class loader sub system(Loading,Linking,Initialize) --> Run time area (method area,heap,java stack,PC registers,Native Stack Method) --> JVM(Interpreter,JIT compiler) --> operating system
Byte Code is platform Independent but JVM is platform dependent.JVM is different for windows,mac,linux...
Every Java Program will have an inbuilt Main Thread

//System.out.println() -->System is a class preset in java.lang package
                       -->out is a static variable present in system class of type PrintStream() class
                       -->Println() is a method present in PrintStream Class()
                       -->This Println() method convert the value address to value using toString() and display the output
 */
public class _1_Adding_two_integers {
    public static void main(String[] args) { //Here we use static as to call main we need to create an object and to create the object we need to start execution to avoid this contradiction we use static keyword "here" refer static keyword file for clarity
        System.out.print("here if ln not present in print then it will print the same order rather in next line");
        int a = 4;
        int b = 4;
        int sum = a + b;
        System.out.println(sum);
        //*****
        System.out.println(100+100+"sadiq"); //200sadiq --> here JVM consider first + sign as Addition and Next + sign as concatenation
        System.out.println("sadiq"+100+100);//sadiq100100
        //Print() Functions
        System.out.println("sa\bdiq"); //backspace which delete before letter --> sdiq
        System.out.println("sad\fiq"); //form feed keep a space for another letter after that -->sad iq
        System.out.println("sad\niq"); //new Line --> sad
                                                    // iq
        System.out.println("sad\riq"); //carriage return will delete before elements--> iq
        System.out.println("sad\tiq"); //horizontal tab will give space --> sad iq
        System.out.println("sad\\iq"); //backspace to print \ in print statement if we just write \ we cannot get the output it will take it as a keyword
        System.out.println("sad\'iq"); //single quote to print ' in print statement if we just write ' we cannot get the output it will take it as a keyword
        System.out.println("sad\"iq"); //double quote to print " in print statement if we just write " we cannot get the output it will take it as a keyword
    }
}
