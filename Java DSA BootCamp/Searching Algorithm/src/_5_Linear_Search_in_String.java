import java.util.*;
public class _5_Linear_Search_in_String {
    public static String LinearSearch(String name, char target){
        int count=-1;
        if(name.length()==0){ //***Here Length have brackets as name is a variable
            System.out.println("String is empty");
        }
        for(int i=0;i<name.length();i++){
            if(target==name.charAt(i)){
                count=i;
                break;
            }
        }
        if(count==-1){
            System.out.println("Element is not present in the Array");
        }
        else{
            System.out.println("Element is present at Index "+count +"\n"+"Element is present in the place "+(count+1));
        }
        return "Program is Executed";
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String");
        String name=sc.nextLine();

        System.out.println("Enter the Target Letter to be Searched :");
        char target=sc.next().charAt(0);

        String result=LinearSearch(name,target);
    }
}
