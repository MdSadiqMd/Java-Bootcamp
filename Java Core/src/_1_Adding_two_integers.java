/*
static type means we need to specify the type of Variable ex:java
ex: int a=10;
    a="sadiq"; o/p:error
In Dynamically typed language means we don't need to specify the type of the variable ex:python
ex: a=10
    a="sadiq" o/p:sadiq

If No pointer is pointed to an Object then it goes to Garbage Collector Automatically

Here variable a,main method main,... are Identifiers and the values are Literals

.class file --> class loader sub system(Loading,Linking,Initialize) --> Run time area (method area,heap,java stack,PC registers,Native Stack Method) --> JVM(Interpreter,JIT compiler) --> operating system
Byte Code is platform Independent but JVM is platform dependent.JVM is different for windows,mac,linux...
Every Java Program will have an inbuilt Main Thread
 */
public class _1_Adding_two_integers {
    public static void main(String[] args) { //Here we use static as to call main we need to create an object and to create the object we need to start execution to avoid this contradiction we use static keyword "here" refer static keyword file for clarity
        System.out.print("here if ln not present in print then it will print the same order rather in next line");
        int a = 4;
        int b = 4;
        int sum = a + b;
        System.out.println(sum);
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
