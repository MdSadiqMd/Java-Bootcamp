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

        //Ternary operator
        int c=4;
        int d=5;
        int e=5;
        int result=(c>d)?c:d; //here if a>b then it will print a if not it will print b
        String result1=(c>d)?"c is greater":"d is greater"; //*** should give string before it
        System.out.println(result);
        System.out.println(result1);

        //if,else if and else in ternary operator
        int result2=(c<d)?((d<e)?c:e):(d<e)?d:e;
        System.out.println(result2);

    }
}
