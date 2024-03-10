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
    public static void main(String[] args) {
        int[] arr={2, 4, 6, 8, 8, 8, 11, 13};
        int k=8,n=arr.length;
        System.out.println(Arrays.toString(countLowerAndUpperBound(arr, n, k)));
        System.out.println(Arrays.toString(countLowerAndUpperBoundRecursive(arr, n, k)));
    }
}
