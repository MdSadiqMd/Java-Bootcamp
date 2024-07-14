public class Minimum_in_Rotated_Sorted_Array {
    public static int findMin(int[] arr) {
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[high]) return arr[low];
            else if(arr[mid]>arr[high]) low=mid+1;
            else high=mid;
        }
        return arr[low];
    }
    public static int findMinRecursive(int[] arr,int low,int high) {
        int mid=low+(high-low)/2;
        if(arr[low]<=arr[high]) return arr[low];
        else if(arr[mid]>arr[high]) return findMinRecursive(arr,mid+1,high);
        else return findMinRecursive(arr,low,mid);
    }
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMinRecursive(new int[]{3,4,5,1,2},0,4));
    }
}
