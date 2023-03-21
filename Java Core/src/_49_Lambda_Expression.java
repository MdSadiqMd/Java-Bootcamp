/*
we are going to use lambda expression previous code
Lambda expression is used to shorten the code as giving pre boilerplate code as in HTML as we can concentrate more on logic
syntax: (parameter-list) - > {body}
the basic functioning of lambda expression is it guess our intentions to create an object
the drawback is it works only for one method
 */
@FunctionalInterface //not do much just give a customized error if more methods are defined
interface car1{
   void drive();
   //void show(); --> works only for one method
}
public class _49_Lambda_Expression {
    public static void main(String[] args) {
        /* car obj=new car(){
            public void drive(){
                System.out.println("Driving...");
            }
        };
                           (or)*/
        car1 obj = ()-> System.out.println("Driving.."); //this is called lambda expression with no parameters as the lines of code is only one wwe no need to use {}
        obj.drive();
        //for objects having one parameter
        /*car1 obj1=new car1(){
            public void drive(int avg){
                System.out.println("Driving...");
            }
        };
                   (or)
         car obj=avg->System.out.println("Driving...");
         obj.drive(16)*/
        //do the same with two or more parameters but, we need to keep brackets
        /*car obj=(avg1,avg2)->System.out.println("Driving...");
        obj.drive(16,18)*/
        }
    }

