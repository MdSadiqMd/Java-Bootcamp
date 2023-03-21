//Difference between throw and throws keyword --> throw is used to throw the exception at cause block and throws is used to forward exception to other method usually Ducking
//                                            --> throws is written st method name and throw is written in a method
//                                            --> throw need an object to execute and throws don't need an object to execute
//                                            --> Program will run without both throw and throws
//Why  do we use throw Keyword --> throw statement is like return statement we can write whole try and catch block or just print exception using throw keyword
//Checked: Occur during the compilation. Here, the compiler checks whether the exception is handled and throws an error accordingly.
//Unchecked: Occur during program execution. These are not detectable during the compilation process.
//Checked and Unchecked errors in Exceptional Handling --> here the runtime errors are checked by compiler others compiler won't care called unchecked errors this usually follows the hierarchy where the object at the top and throwable at next and left side are checked and left side are unchecked exceptions --> check the diagram
//Handling --> handling the exception using try and catch in the same block is called handling
//Ducking --> we push the error to other block to handle
//But why we need ducking for an example main method has two class x and y if they both throw same exception and present in same block it's kind a confusing, so we just push it to other block to handle ****it all depends upon the design of the code
//Understanding code order --> overview --> a --> main

class demo{
    public void a(){
        //here the a() block not have any problem in execution, but we are calling b in a throws an exception, so we put it in try catch statement symbolises the error in be is handled by a or b had ducked(thrown) error to a to handle
        System.out.println("a");
        int value=9;
        /*try{
            b();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }*/
    }
    public void b() throws Exception{ //Here we specify to the compiler or the programmer that this block can throw the exception
        int num1=0;                   //******throws and throw are different
        int num2=0;
        try{
            int result=num1/num2;
            System.out.println(result);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
public class _51_Ducking {
    public static void main(String[] args) /*throws Exception*/ {  // --> ***here when we write the throws exception it will forward it to JVM it works but don't do that
        demo obj=new demo();
        obj.a();
        //b can also duckled the error on to main method
        try{
            obj.a();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
