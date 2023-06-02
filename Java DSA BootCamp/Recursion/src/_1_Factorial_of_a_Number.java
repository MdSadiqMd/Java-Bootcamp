import java.util.*;
//The Working of the recursive calls is due to Stack Data Structure, Every level of stack call the lower level and return the value of the top
//so, the space complexity is O(n)
//The recursive function makes n recursive calls, each time reducing the input value by 1 until it reaches the base case (usually when n equals 0 or 1). Therefore, the number of recursive calls is directly proportional to the input number n
//Time Complexity is O(n)
public class _1_Factorial_of_a_Number {
    public static int factorial(int n) {
        int result;
        if(n==0 || n==1){ //base case condition
            return 1;
        }
        else {
            result=n*factorial(n-1); //recursive calling
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number :");
        int n=sc.nextInt();

        int result=factorial(n);
        System.out.println(result);
    }
}
