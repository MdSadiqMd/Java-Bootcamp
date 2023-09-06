/*
Given an integer array arr and an integer k, return true if it is possible to divide the vector into k non-empty subsets with equal sum
Input:arr = [1,3,2,2] k = 2
Output:true
Explanation: 1 + 3 and 2+2 are two subsets with equal sum.
 */
import java.util.Arrays;

public class Non_Empty_SubSets {
    public static boolean canDivideIntoSubsets(int[] arr, int k) {
        int sum = Arrays.stream(arr).sum(); // Calculate the sum of all elements in the array
        if (sum % k != 0) {
            return false; // If the sum is not divisible by k, it's not possible to divide into equal subsets
        }

        int targetSum = sum / k; // Calculate the target sum for each subset

        boolean[] visited = new boolean[arr.length];
        return canPartition(arr, visited, 0, k, 0, targetSum);
    }

    public static boolean canPartition(int[] arr, boolean[] visited, int start, int k, int currentSum, int targetSum) {
        if (k == 1) {
            return true; // If we have divided the array into k-1 subsets with equal sum, the remaining subset will also have the same sum
        }

        if (currentSum == targetSum) {
            return canPartition(arr, visited, 0, k - 1, 0, targetSum); // Recursively check for the next subset
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (canPartition(arr, visited, i + 1, k, currentSum + arr[i], targetSum)) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2};
        int k = 2;
        boolean result = canDivideIntoSubsets(arr, k);
        System.out.println(result);
    }
}
