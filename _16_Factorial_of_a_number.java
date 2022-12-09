public class _16_Factorial_of_a_number {
    public static void main(String[] args) {

        //using While Loop

        int n = 5;
        int i = 1;
        int fact1 = 1;
        while (i <= n) {
            fact1 *= i;
            i++;
        }
        System.out.println("while Loop:" + fact1);

        //using for loop

        int fact=1;
        for (int a= 5;i<=a; i++){
            fact*= i;
        }
        System.out.println("for loop:" + fact);

        //using do-while loop

        int b=5;
        int fact3 =1;
        do{
            fact3 *=i;
            i++;
        }while(i<=b);
        System.out.println("do-while loop:"+fact3);
    }
}
