import java.util.*;
// 1. Given a sorted binary array, efficiently count the total number of 1’s in it --> Input 1: arr = [0 0 0 0 1 1 1 1 1 1] --> Output 1: 6
// 2. Given a sorted integer array containing duplicates, count occurrences of a given number. If the element is not found in the array, report that as well --> Input: arr[] = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9] --> target = 5 --> Output: Target 5 occurs 3 times
public class Problems_Binary_Search {
    //1.
    /*public static int BinarySearch(int[] arr, int low, int high){
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
    }*/
    //2.
    public static int BinarySearch(int[] arr,int k){
        int low=0;
        int high=arr.length-1;
        int count=0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] ==k){
                count++;
                int i=mid-1;
                if(i>=low && arr[mid]==k){
                    count++;
                    --i;
                }
                int j=mid+1;
                if(j<=high && arr[mid]==k){
                    count++;
                    ++j;
                }
                return count;
            } else if (arr[mid]<k) {
                low=mid-1;
            } else {
                high=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n=sc.nextInt();

        int []arr = new int[n];

        System.out.print("Enter the elements of the array: ");

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the target :");
        int k=sc.nextInt();
        //1. int result = BinarySearch(arr , 0 , n - 1);
        int result = BinarySearch(arr ,k);
        if (result == -1) {
            System.out.println("The element is not present in the array");
        } else {
            System.out.println("Occurrences of " + k + " in the array: " + result);
        }
    }
}
