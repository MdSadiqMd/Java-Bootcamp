// 1. Find the Element in the Array using Linear Search
// 2. Find last occurrence of the element in the array --> Iterate from back --> arr.length-1
// 3. Find Minimum Element in the Array
import java.util.*;
public class Problems_Linear_Search {
    //1.
    /*public static int LinearSearch(int[] arr,int k){
        int count=-1;
        for(int i=0;i<arr.length;i++){
            while(arr[i]==k){
                count=i;
                break;
            }
            return count;
        }
        return -1;
    }*/

    //2.
    /*public static int LinearSearch(int[] arr,int k){
        int count=-1;
        for(int i=arr.length-1;i>=0;i--){
            while(arr[i]==k){
                count=i;
                break;
            }
            return count;
        }
        return -1;
    }*/

    //3.
    public static int LinearSearch(int[] arr, int n) {
        int min = arr[0];  // Assume the first element as the minimum

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];  // Update the minimum value
            }
        }

        System.out.println("Minimum value: " + min);
        return -1; //********remove this for the problem
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