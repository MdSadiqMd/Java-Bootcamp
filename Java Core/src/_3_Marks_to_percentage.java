import java.util.Scanner;
public class _3_Marks_to_percentage {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter marks 1:");
        int a=sc.nextInt();
        System.out.println("enter marks 2:");
        int b=sc.nextInt();
        int average=(a+b)/2;
        System.out.println(average);
        //Program for Counting the number Occurrences
        int rem;
        int c=0;
        while(a>0){
            rem=a%10;
            if(rem==3){
                c++;
            }
            a=a/10;
        }
        System.out.println(c);
        //Program to Reverse a number
        int d=12345;
        int rem1;
        int ans=0;
        while(d>0){
            rem1=d%10;
            d/=10;
            ans=ans*10+rem1;
        }
        System.out.println(ans);
    }
}
