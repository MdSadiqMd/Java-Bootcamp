import java.util.Scanner;
// Here we divide the problem into two half
//Even power = 2^64 = 2^32 * 2^32
//Odd Power = 2^65 = 2 * 2^32 * 2^32
public class _4_Finding_Power_Using_Recursion_Optimized {
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
