import java.util.*;
/*
Selection Sort --> Here we Sort on the Basis of Index
                   First we collect the index of minimum element index, and then we Swap Both
                   Later, we sort each and every element
 */
public class _3_Selection_Sort {
    public static void SelectionSort(int[] arr) {
        for(int i=0;i<arr.length;i++){
            int MinIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if (arr[j] < arr[MinIndex]){
                    MinIndex=j;
                }
            }
            if(MinIndex!=i){
                int temp=arr[MinIndex];
                arr[MinIndex]=arr[i];
                arr[i]=temp;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the Number of Elements of the Array :");
        int n=sc.nextInt();
        System.out.println("Enter the Elements of the Array :");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        SelectionSort(arr);
        System.out.println("The Sorted Array is :");
        System.out.print(Arrays.toString(arr));
    }
}
