import java.util.Scanner;
public class _9_Armstrong_Number_Using_Recursion {
    public static int power(int a, int b){
        if(b == 0) {
            return 1;
        } else if (b%2 == 0) {
            return power(a, b / 2) * power(a, b / 2);
        } else {
            return a * power(a, b / 2) * power(a, b / 2);
        }
    }
    public static int isArmstrong(int n , int digits){
        if(n == 0) {
            return 0;
        } else {
            return power(n % 10, digits) + isArmstrong(n / 10, digits);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(" Enter the Number :");
        int n=sc.nextInt();
        int digits = 0;
        int temp = n;
        while(temp > 0){
            digits++;
            temp/=10;
        }
        if(n == isArmstrong(n , digits)) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }
}
