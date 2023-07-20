import java.util.Scanner;
/*
Find the minimum sum of Products of two arrays of the same size, given that k modifications
are allowed on the first array. In each modification, one array element of the first array can either
be increased or decreased by 2.

Explanation:
a[] = {1, 2, -3}
b[] = {-2, 3, -5}
k = 5
Here n = 3 and k = 5.
So, we modified a[2], which is -3 and increased it by 10 (as 5 modifications are allowed).
Final sum will be :
(1 * -2) + (2 * 3) + (7 * -5)
-2 + 6 - 35
-31
(which is the minimum sum of the array with given conditions)
 */

public class _6_Minimum_Sum {

    public static int minIndex(int[] b) {
        int min = 0; // Initialize the minimum index to 0
        for (int i = 0; i < b.length; i++) {
            if (b[i] < b[min]) { // Compare with the current minimum
                min = i; // Update the minimum index
            }
        }
        return min; // Return the minimum index
    }

    public static int minSum(int[] a, int[] b, int k, int min) {
        a[min] += k ; // Update the3 value at the minimum index by adding k*2
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i]; // Calculate the sum of products of both arrays
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {2, 3, 4, 5, 4};
        int[] b = {3, 4, 2, 3, 2};
        System.out.println("Enter the Number of Operations:");
        int k = sc.nextInt();
        int min = minIndex(b); // Get the minimum index
        int result = minSum(a, b, k, min); // Calculate the minimum sum
        System.out.println("Minimum sum of products: " + result);
    }
}
