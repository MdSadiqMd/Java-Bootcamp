import java.util.Scanner;
public class _9_If_else_statement {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("enter age of the person:");
        int a=sc.nextInt();
        if (a==18){
            System.out.println("the person is perfectly eligible to vote");
        }
        else if(a>=18){
            System.out.println("the person id eligible to vote");
        }
        else{
            System.out.println("the person is not eligible to vote");
        }

        //here we are using boolean expression to evaluate the if-else condition

        int b=19;
        boolean condition=(b>=18);
        if (condition){
            System.out.println("the person is eligible to vote - boolean output");
        }
        else{
            System.out.println("the person is not eligible to vote - boolean output");
        }
    }
}
