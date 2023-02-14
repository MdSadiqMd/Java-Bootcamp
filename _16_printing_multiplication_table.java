import java.util.Scanner;
public class _16_printing_multiplication_table {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("enter the number:");
        int n=sc.nextInt();
        int sum =0;
        for(int i=1;i<=10;i++){
            System.out.format("%d*%d=%d \n ",n ,i ,n*i);//use .format not println
            sum+=n*i;
        }
        System.out.println("the sum of multiplication values is:"+sum);//this prints the sum of values of the result of the multiplications
    }
}
