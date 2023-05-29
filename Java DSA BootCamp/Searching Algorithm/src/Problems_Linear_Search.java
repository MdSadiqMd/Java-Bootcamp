import java.util.Scanner;

public class Problems_Linear_Search {
    public static void linearSearch(int[] arr, int n) {
        int min = arr[0];  // Assume the first element as the minimum

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];  // Update the minimum value
            }
        }

        System.out.println("Minimum value: " + min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the 1D Array:");
        int n = sc.nextInt();

        // 1D Array
        System.out.println("Enter the values of the 1D Array:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        linearSearch(arr, n);
    }
}
