import java.util.Scanner;
public class _12_Switch_case_statement {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the age of the person");
        int age=sc.nextInt();

        //Switch Case Using Lambda Expressions

        switch (age) {
            case 23 -> System.out.println("get ready for placements");
            case 30 -> System.out.println("become a millionaire");
            case 45 -> System.out.println("work hard for retirement");
            case 60 -> System.out.println("become a angel investor");
            case 80 -> System.out.println("ready for end");
            default -> System.out.println("rerun the code and enter again");
        }

        // using switch statements for strings

        String str="sadiq";
        switch(str){
            case "sadiq" :
                System.out.println("get ready for placements");
                break;
            case "akhil" :
                System.out.println("become a millionaire");
                break;
            case "sanjay" :
                System.out.println("work hard for retirement");
                break;
            case "prakash" :
                System.out.println("become a angel investor");
                break;
            case "ravikanth" :
                System.out.println("ready for end");
                break;
            default:
                System.out.println("rerun the code and enter again");
        }
    }
}
