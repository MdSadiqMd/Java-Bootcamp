/*
Nothing Program execution
.class file --> class loader sub system(Loading,Linking,Initialize) --> Run time area (method area,heap,java stack,PC registers,Native Stack Method) --> JVM(Interpreter,JIT compiler) --> operating system
 */
public class _1_Adding_two_integers {
    public static void main(String[] args) { //here we use static as to call main we need to create an object and to create the object we need to start execution to avoid this contradiction we use static keyword "here" refer static keyword file for clarity
        System.out.print("here if ln not present in print then it will print the same order rather in next line");
        int a = 4;
        int b = 4;
        int sum = a + b;
        System.out.println(sum);
        //Print() Function
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
