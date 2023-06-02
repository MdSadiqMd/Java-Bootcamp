import java.util.*;
public class _2_Fibonacci_Series {
    public static int Fibonacci(int n){
        if(n<=1){
            return n;
        }
        else{
           return Fibonacci(n-1)+Fibonacci(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number of Steps do the Fibonacci series should be displayed :");
        int n=sc.nextInt();
        int result=Fibonacci(n);
        System.out.println(result);
    }
}
