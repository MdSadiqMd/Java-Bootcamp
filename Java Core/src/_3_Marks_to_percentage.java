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

    }
}
