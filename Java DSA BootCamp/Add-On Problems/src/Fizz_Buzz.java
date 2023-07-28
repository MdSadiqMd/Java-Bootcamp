import java.util.Scanner;
public class Fizz_Buzz {
    public void Solution(int n){
        for(int i=0;i<=n+1;i++){
            if(i%5==0 && i%3==0){
                System.out.println("FizzBuzz");
            } else if (i%3==0) {
                System.out.println("Fizz");
            } else if (i%5==0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
    public void optimizedSolution(int n){
        for(int i=0;i<n+1;i++){
            String output=" ";
            if(i%3==0){
                output+="Fizz";
            }
            if(i%5==0){
                output+="Buzz";
            }
            if(output==" "){
                output+=i;
            }
            System.out.println(output);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Number : ");
        int n=sc.nextInt();
        Fizz_Buzz FizzBuzz=new Fizz_Buzz();
        FizzBuzz.Solution(n);
        FizzBuzz.optimizedSolution(n);
    }
}
