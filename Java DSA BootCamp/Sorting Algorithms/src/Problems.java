import java.util.*;
// 1. Bubble sort in Descending order
// 2. Insertion Sort in Descending Order
// 3. Selection Sort in Descending Order
// 4. Return the count of number of iterations of Bubble sort
// 5. Return the count of number of iterations of Selection sort
public class Problems {
    // 1.
    /*public static void Sorting(int[] arr){
        for(int i=arr.length-1;i>=0;i--){
            boolean swap=false;
            for(int j= arr.length-1;j>0;j--){ // j>0 not j>=0
                if(arr[j]>arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swap=true;
                }
            }
            if(!swap){
                break;
            }
        }
    }*/

    // 2.
    /*public static void Sorting(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++){
            // Find the maximum element in unsorted part of the array
            int max_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[max_index])
                    max_index = j;
            }

            // Swap the found maximum element with the current element
            if (max_index != i) {
                int temp = arr[max_index];
                arr[max_index] = arr[i];
                arr[i] = temp;
            }
        }
    }*/

    // 3.
    /*public static void Sorting(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int MinIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[MinIndex]) { // Compare with > for descending order
                    MinIndex = j;
                }
            }
            if (MinIndex != i) {
                int temp = arr[i];
                arr[i] = arr[MinIndex];
                arr[MinIndex] = temp;
            }
        }
    }*/

    // 4.
    /*public static int Sorting(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            count++;
        }
        return count;
    }*/

    // 5.
    public static int Sorting(int[] arr) {
        int count=0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int MinIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[MinIndex]) { // Compare with > for descending order
                    MinIndex = j;
                }
            }
            if (MinIndex != i) {
                int temp = arr[i];
                arr[i] = arr[MinIndex];
                arr[MinIndex] = temp;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Elements of the Array:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the Elements of the Array:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int result=Sorting(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(result); //for 4 and 5 questions
    }
}