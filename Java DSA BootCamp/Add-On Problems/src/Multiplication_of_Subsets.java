/*
Check if the product of some subset of an array is equal to the target value
Input :n = 5 , target = 16
Array = [2 3 2 5 4]
 2x2x4 = 16
Output:YES
 */
public class Multiplication_of_Subsets {
    public static boolean hasSubsetProduct(int[] arr, int target) {
        return hasSubsetProductHelper(arr, 0, target, 1);
    }

    private static boolean hasSubsetProductHelper(int[] arr, int index, int target, int currentProduct) {
        if (currentProduct == target) {
            return true;
        }

        if (index >= arr.length || currentProduct > target) {
            return false;
        }

        // Include the current element in the product
        if (hasSubsetProductHelper(arr, index + 1, target, currentProduct * arr[index])) {
            return true;
        }

        // Exclude the current element from the product
        if (hasSubsetProductHelper(arr, index + 1, target, currentProduct)) {
            return true;
        }

        // Neither including nor excluding the current element leads to the target product
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 5, 4};
        int target = 17;

        boolean hasSubset = hasSubsetProduct(arr, target);
        System.out.println(hasSubset ? "YES" : "NO");
    }
}

