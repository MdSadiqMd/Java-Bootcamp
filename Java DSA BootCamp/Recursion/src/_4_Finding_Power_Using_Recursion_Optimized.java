import java.util.Scanner;
// Here we divide the problem into two half
//Even power = 2^64 = 2^32 * 2^32
//Odd Power = 2^65 = 2 * 2^32 * 2^32
public class _4_Finding_Power_Using_Recursion_Optimized {
    public static int power(int n,int m){
        if(m == 0) { //Base Condition
            return 1;
        } else if (m%2==0) {
            int result = power(n,m/2);
            return result*result;
        } else{
            int result = power(n,(m-1)/2);
            return n*result*result;
        }
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
