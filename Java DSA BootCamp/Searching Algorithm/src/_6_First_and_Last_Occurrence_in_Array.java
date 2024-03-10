import java.util.Arrays;

public class _6_First_and_Last_Occurrence_in_Array {
    // Count Occurrence in Array --> https://takeuforward.org/data-structure/count-occurrences-in-sorted-array/
    public static int[] countLowerAndUpperBound(int[] arr, int n, int k){
        int lb= _5_Lower_Bound_and_Upper_Bound.lowerBound(arr,n,k);
        if(lb==n || arr[lb]!=k) return new int[]{-1,-1};
        int ub= _5_Lower_Bound_and_Upper_Bound.upperBound(arr, n, k);
        return new int[]{lb,ub-1};
    }
    public static int[] countLowerAndUpperBoundRecursive(int[] arr, int n, int k){
        int lb= _5_Lower_Bound_and_Upper_Bound.lowerBoundRecursive(arr,k,0,n);
        if(lb==n || arr[lb]!=k) return new int[]{-1,-1};
        int ub= _5_Lower_Bound_and_Upper_Bound.upperBoundRecursive(arr,k,0,n);
        return new int[]{lb,ub-1};
    }
    public static int firstOccurrenceHelper(int[] arr, int n, int k){
        int low = 0,high = n - 1,first=-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                first=mid;
                high=mid-1;
            }
            else if (arr[mid] < k) low = mid + 1;
            else high = mid - 1;
        }
        return first;
    }
    public static int lastOccurrenceHelper(int[] arr, int n, int k){
        int low = 0,high = n - 1,last=-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                last=mid;
                low=mid+1;
            }
            else if (arr[mid] < k) low = mid + 1;
            else high = mid - 1;
        }
        return last;
    }
    public static int[] countBinary(int[] arr, int n, int k){
        int first=firstOccurrenceHelper(arr,n,k);
        if(first==-1) return new int[]{-1,-1};
        int last=lastOccurrenceHelper(arr,n,k);
        return new int[]{first,last};
    }
    public static int firstOccurrenceHelperRecursive(int[] arr, int k, int l, int h) {
        if (l > h) return -1;
        int mid = l + (h - l) / 2;
        if (arr[mid] == k) {
            int first = firstOccurrenceHelperRecursive(arr, k, l, mid - 1);
            if (first == -1) return mid;
            else return first;
        }
        else if (arr[mid] < k) return firstOccurrenceHelperRecursive(arr, k, mid + 1, h);
        else return firstOccurrenceHelperRecursive(arr, k, l, mid - 1);
    }

    public static int lastOccurrenceHelperRecursive(int[] arr, int k, int l, int h) {
        if (l > h) return -1;
        int mid = l + (h - l) / 2;
        if (arr[mid] == k) {
            int last = lastOccurrenceHelperRecursive(arr, k, mid + 1, h);
            if (last == -1) return mid;
            else return last;
        }
        else if (arr[mid] < k) return lastOccurrenceHelperRecursive(arr, k, mid + 1, h);
        else return lastOccurrenceHelperRecursive(arr, k, l, mid - 1);
    }
    public static int[] countBinaryRecursive(int[] arr, int n, int k) {
        int first = firstOccurrenceHelperRecursive(arr, k, 0, n - 1);
        if (first == -1) return new int[]{-1, -1};
        int last = lastOccurrenceHelperRecursive(arr, k, 0, n - 1);
        return new int[]{first, last};
    }
    public static void main(String[] args) {
        int[] arr={2, 4, 6, 8, 8, 8, 11, 13};
        int k=8,n=arr.length;
        System.out.println(Arrays.toString(countLowerAndUpperBound(arr, n, k)));
        System.out.println(Arrays.toString(countLowerAndUpperBoundRecursive(arr, n, k)));
        System.out.println(Arrays.toString(countBinary(arr, n, k)));
        System.out.println(Arrays.toString(countBinaryRecursive(arr, n, k)));
    }
}
