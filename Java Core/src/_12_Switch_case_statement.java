import java.util.Scanner;
public class _12_Switch_case_statement {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the age of the person");
        int age=sc.nextInt();
        switch(age){
            case 23:
                System.out.println("get ready for placements");
                break;
            case 30:
                System.out.println("become a millionaire");
                break;
            case 45:
                System.out.println("work hard for retirement");
                break;
            case 60:
                System.out.println("become a angel investor");
                break;
            case 80:
                System.out.println("ready for end");
                break;
            default:
                System.out.println("rerun the code and enter again");
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
            case "ravikant" :
                System.out.println("ready for end");
                break;
            default:
                System.out.println("rerun the code and enter again");
        }
    }
}
