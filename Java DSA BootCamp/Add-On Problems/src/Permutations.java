public class Permutations {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void permutation(int[] arr, int start, int last) {
        if (start == last) {
            // Base case: Print the permutation
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= last; i++) {
                // Swap the current element with the element at the start index
                swap(arr, start, i);
                // Recursively generate permutations for the remaining elements
                permutation(arr, start + 1, last);
                // Restore the original order by swapping back
                swap(arr, start, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permutation(arr, 0, arr.length - 1);
    }
}
