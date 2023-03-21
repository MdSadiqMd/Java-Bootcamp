/*
the following is called anonymous class where you define the method without the class(but it is considered as a class by JDK)
the drawback of this is we can use this only once for example we cannot create an object with name obj1 and use drive method but, we can use other methods
 */
interface car{
    void drive();
}
/*class suzuki implements car{
    public void drive(){
        System.out.println("Driving....");
    }
}*/
public class _48_Annonymos_Inner_Class {
    public static void main(String[] args) {
        /*car obj=new suzuki();
        obj.drive();*/ //--> this code gives correct output no doubt about it but what if we want to get output with the same class name without using upper method
                       //ex:car obj=new car();
                      //    obj.drive(); --> we get an error so, we create a method inside the car constructor
        car obj=new car(){
            public void drive(){
                System.out.println("Driving...");
            }
        }; //write the code between closing of brackets and semicolon
        obj.drive();
    }
}
