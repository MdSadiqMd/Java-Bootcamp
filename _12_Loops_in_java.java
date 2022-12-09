public class _12_Loops_in_java {
    public static void main(String[] args) {

        //while loop

        int a=1;
        System.out.println("printing numbers - while loop output:");
        while(a<=5){
            System.out.println(a);
            a++;
        }

        //Do-while Loop

        int b=1;
        System.out.println("printing odd numbers - do-while loop output:");
        do{
            System.out.println(b);
            b=b+2;
        }while(b<=20);

        //for loop

        System.out.println("printing even numbers - for loop output:");
        for (int c=0;c<=20;c=c+2){
            System.out.println(c);
        }
    }
}
