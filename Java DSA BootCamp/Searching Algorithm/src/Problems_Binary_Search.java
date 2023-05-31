import java.util.*;
// 1. Given a sorted binary array, efficiently count the total number of 1’s in it --> Input 1: arr = [0 0 0 0 1 1 1 1 1 1] --> Output 1: 6
public class Problems_Binary_Search {
    //1.
    public static int BinarySearch(int[] arr, int low, int high){
        while(low <= high){
            int mid = low + (high  - low)/2;

            if(arr[mid] == 0){
                low = mid + 1;
            }
            else {
                high  = mid - 1;
            }
        }
        return (arr.length - low);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n=sc.nextInt();

        int []arr = new int[n];

        System.out.print("Enter the elements of the array: ");

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int result = BinarySearch(arr , 0 , n - 1);

        System.out.println("The Answer is: " + result);
    }
}
