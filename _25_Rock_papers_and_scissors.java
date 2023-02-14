import java.util.Scanner;
import java.util.Random;  //importing the random user input program
public class _25_Rock_papers_and_scissors {
    public static void main(String[] args) {

        //giving user input

        Scanner sc=new Scanner(System.in);
        System.out.println("give your input");
        int userInput=sc.nextInt();

        //generating computer input randomly using random function

        Random random=new Random();
        int computerInput=random.nextInt();

        //conditions of rock paper scissors
        //0--rock,1--paper,2--scissor

        if(userInput==computerInput){
            System.out.println("Draw");
        }
        else if(userInput==0 && computerInput==2 || userInput==1 && computerInput==0 || userInput==2 && computerInput==1 ) {
            System.out.println("i have won");
        }
        else{
            System.out.println("you're out");
        }

        //the computer chosen input

        if(computerInput==0){
            System.out.println("computer Input:rock");
        }
        else if(computerInput==1){
            System.out.println("computer Input:paper");
        }
        else if(computerInput==2){
            System.out.println("computer Input:scissor");
        }
    }
}
