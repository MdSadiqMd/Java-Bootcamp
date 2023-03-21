//Why do we need exception handling--> If there is no try and catch block while an exception occurred, the program gill terminate Exception handling-endured the smooth running of a program without program termination
//we can write program try and catch without finally
//we cannot write catch and finally without try
//we can write try and finally without catch but, it's silly to do it
public class _50_Try_and_Catch {
    public static void main(String[] args) {
        int a=5;
        int b=1;
        int c=0; //initializing c
        int values[]={4,5,6,7};
        try{
            //*****here now we have given one error creating statement and other now mal statement and if we run it now then the successful statement will also not print so, we create some catch blocks that will catch specific exceptions and return the successful statements
            c=a/b; //successful statement
            System.out.println(values[10]); //error statement
            //here we have a throw keyword for which we need to create the object to access it will return the object name as exception and redirect to catch blocks
            Exception e = new Exception();
            throw e;
        }
        //customizable errors
        catch(ArithmeticException e){
            System.out.println(e.toString()); //here will return value error if we enter a string in place of integer
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        //this block act as default error output if we don't know what error could occur
        catch (Exception e) { //we can write any variable in place of e
            // c=a/b; --> **we can perform operations in catch block also
            System.out.println("Error"+e);
        }
        finally{ //will execute irrespective of the program
            //sc.close(); --> we write this when we use dynamic input
            System.out.println("finally block");
        }
        System.out.println(c);
    }
}
