import java.util.*;
public class _3_Finding_Power_Using_Recursion_Brute_Force {
    public static int power(int n,int m){
        int result=0;
        if (n==0){
            result=0;
        } else if (n==1 || m==0) {
            result=1;
        } else {
            result=n*power(n,m-1);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number :");
        int n=sc.nextInt();

        System.out.println("Enter the Power :");
        int m=sc.nextInt();

        System.out.println("The Answer is "+power(n,m));
    }
}
