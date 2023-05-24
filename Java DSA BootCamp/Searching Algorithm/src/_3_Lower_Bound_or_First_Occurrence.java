import java.util.*;
public class _3_Lower_Bound_or_First_Occurrence {
    public static int BinarySearch(int[] arr,int target) {
        int low = 0;
        int high = arr.length - 1;
        int result=-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result=mid;
                high=mid-1; //searching if there is a first occurrence or not by traversing left
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number of elements of an Array :");
        int n=sc.nextInt();

        int[] arr=new int[n];
        System.out.println("Enter the Elements of the Array :");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("Enter the element to be searched :");
        int target=sc.nextInt();

        int result=BinarySearch(arr,target);
        int mid=BinarySearch(arr,target);
        if (result!=-1) {
            System.out.println("Element found at index " + result);
        } else{
            System.out.println("Element is not Present");
        }
    }
}
