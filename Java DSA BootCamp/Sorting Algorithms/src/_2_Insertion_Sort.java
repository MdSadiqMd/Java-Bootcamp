import java.util.*;
/*
Insertion Sort Tally Each and Every Element and Sort it based on the Order
Insertion sort is a simple sorting algorithm that works by dividing an array into a sorted and an unsorted part.
Initially, the sorted part contains only the first element of the array, and the unsorted part contains the remaining elements.
The algorithm repeatedly takes an element from the unsorted part and inserts it into its correct position in the sorted part.
This process continues until the entire array is sorted.
***Interview Question --> If the Array is sorted which Algorithm you use --> IInsertion Sort as it's time complexity for Sorted Array is O(n) --> Linear Time Complexity
***Interview Question --> If the Array is totally disrupted Which Algorithm you use --> Quick Sort or Merge Sort
It's a Stable and In-Place Algorithm
 */
public class _2_Insertion_Sort {
    public static int InsertionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int j=i;
            while (j>0 && arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number of Elements in the Array :");
        int n=sc.nextInt();
        System.out.println("Enter the Elements of the Array :");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        InsertionSort(arr);
        System.out.println("The Sorted Array is :");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
