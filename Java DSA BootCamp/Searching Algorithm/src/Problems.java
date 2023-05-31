// 1. Find the Element in the Array using Linear Search
import java.util.*;
public class Problems {
    public static int LinearSearch(int[] arr,int k){
        int count=-1;
        for(int i=0;i<arr.length;i++){
            while(arr[i]==k){
                count=i;
                break;
            }
            return count;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Length of the Array :");
        int n=sc.nextInt();

        int[] arr=new int[n];
        System.out.println("Enter the Elements of Array :");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("Enter the Element to be Searched :");
        int k=sc.nextInt();

        int result=LinearSearch(arr,k);
        if(result==-1) {
            System.out.println("The Element is not present in the Array");
        }else {
            System.out.println("The Element is at index "+result);
        }
    }
}
