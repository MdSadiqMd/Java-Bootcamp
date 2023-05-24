import java.util.Scanner;
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

Interview Question : return the index of first infinite
                    Array --> 2 1 7 10 12 infinite infinite infinite
                    first find the mid-value it's 10
                    then low =4 and high =7 and again mid-value =5
                    now index -5 infinite so, return it and for it is first infinite or not tally if the before element is integer or not
 */
public class _2_Binary_Search {
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements of the array:");
        int n = sc.nextInt();

        System.out.println("Enter the elements in the array:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the value to be searched in the array:");
        int target = sc.nextInt();

        // Calling the function
        int result = binarySearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}


