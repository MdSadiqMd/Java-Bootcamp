import java.util.Scanner;
/*
Given a number n. Find the sum of natural numbers till n but with alternate signs.
That means if n = 5 then you have to return 1-2+3-4+5 = 3 as your answer.
Constraints : 0<=n<=1e6
Input1 : n = 10
Output 1 : -5
Explanation : 1-2+3-4+5-6+7-8+9-10 = -5
Input 2 : n = 5
Output 2 : 3
 */
public class _7_Sum_Using_Alternate_Signs {
    public static int SumAlternate(int[] arr,int n){
        if (n == 0) {
            return 0;
        } else if (n%2==0) {
            return -n + SumAlternate(arr,n-1);
        } else {
            return n + SumAlternate(arr,n-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Length of Array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the Array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("The Summation is " +SumAlternate(arr, n));
    }
}
