/*
Binary Search is applicable when the array is ***Logically Sorted
Working of Binary Search --> It will find Middle Index of the Array
                             If the target Element is Middle Index then it will eventually return Middle Index
                             And From here it will terminate Before or After Middle Index as per the Element to be Found
                             And Later again Find Mid-Value and again terminate left or right and land to an Index
                             Time Complexity --> N/(2^k) =1
                                                k=log N to the base 2
Note : When Finding Middle Index we can face the problem of Overflow
      so, write it as mid= low + (high -low) / 2
Order-Agnostic Binary Search: Binary Search is applied on a sorted array but Confirm the given array is Sorted in Ascending (or) Descending Order
                              For that, Compare the first and last Element
Interview Question : return the index of first infinite
                    Array --> 2 1 7 10 12 infinite infinite infinite
                    first find the mid-value it's 10
                    then low =4 and high =7 and again mid-value =5
                    now index -5 infinite so, return it and for it is first infinite or not tally if the before element is integer or not
 */
public class _4_Binary_Search {
    public static int binarySearchIterative(int[] arr, int target) {
        int low = 0,high = arr.length - 1;
        if(arr[low]>arr[high]){ // Sorted in Descending Order
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] == target) return mid;
                else if (arr[mid] < target) high = mid - 1;
                else low = mid + 1;
            }
        }
        else{ // Sorted in Ascending Order
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] == target) return mid;
                else if (arr[mid] > target) high = mid - 1;
                else low = mid + 1;
            }
        }
        return -1;
    }
    public static int binarySearchRecursive(int[] arr,int k,int l,int h){
        if(l>h) return -1;
        int mid=l+(h-l)/2;
        if(arr[mid]==k) return mid;
        if(k>arr[mid]) return binarySearchRecursive(arr,k,mid,h);
        else return binarySearchRecursive(arr,k,l,mid);
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        int k=3;
        System.out.println(binarySearchIterative(arr,k));
        System.out.println(binarySearchRecursive(arr,k,0,arr.length-1));
    }
}


