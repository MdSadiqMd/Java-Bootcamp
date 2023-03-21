import java.util.Scanner;
class Guesser{
    int numguess;
    public void guessnumber() {
       Scanner sc=new Scanner(System.in);
        System.out.println("guess the number:");
        numguess=sc.nextInt();
    }
}
class player{
    int numguess;
    public void guessnumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("player numbers");
        numguess=sc.nextInt();
    }
}
class Umpire{
    Guesser guesser;
    player p1,p2,p3;
    public void GNG(){
        guesser=new Guesser();
        guesser.guessnumber();
    }
    public void GFP(){
        p1=new player();
        p2=new player();
        p3=new player();
        p1.guessnumber();
        p2.guessnumber();
        p3.guessnumber();
    }
    public void result(){
        if(guesser.numguess==p1.numguess){
            if(guesser.numguess==p2.numguess && guesser.numguess==p3.numguess){
                System.out.println("all are winners");
            }
            else if(guesser.numguess==p2.numguess ){
                System.out.println("p1 and p2 are winners");
            }
            else if(guesser.numguess==p3.numguess ){
                System.out.println("p1 and p3 are winners");
            }
            else{
                System.out.println("p1 is winner");
            }
        }
        else if(guesser.numguess==p2.numguess){
            if(guesser.numguess==p3.numguess ){
                System.out.println("p2 and p3 are winners");
            }
            else{
                System.out.println("p2 is winner");
            }
        }
        else{
            System.out.println("p3 is winner");
        }
    }
}
public class _28_Guesser_Game {
    public static void main(String[] args) {
        Umpire umpire=new Umpire();
        umpire.GNG(); //get number from guesser
        umpire.GFP(); //get number from player
        umpire.result();
    }
}
