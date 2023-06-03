import java.util.Scanner;
//Question : count ways to reach the nth step in a staircase if we can climb only one or two steps at a time
/*
example : If the Stairs are 4
  * 1 1 1 1
  * 1 1 2
  * 1 2 1
  * 2 1 1
  * 2 2
 */
//Approach : First write the test cases for various inputs and find relation between the outputs and find the recursive relation
public class _5_Counting_Number_of_stairs {
    public static int Stairs(int n){
        if(n<=1){
            return n;
        }else {
            return Stairs(n-1)+Stairs(n-2);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number of Stairs :");
        int n=sc.nextInt();
        System.out.println("The number of ways to climb the Stairs is :"+Stairs(n+1)); //The Answer for n stairs is the recursive result of n+1 Stairs
    }
}
