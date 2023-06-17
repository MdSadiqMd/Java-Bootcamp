/*
💡 Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

- Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
- Return k.

**Example :**
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_*,_*]

**Explanation:** Your function should return k = 2, with the first two elements of nums being 2. It does not matter what you leave beyond the returned k (hence they are underscores)

 */
public class Remove_the_Occurrences {
    public static int Occurrences(int[] arr, int val) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                count++;
                i--; // Decrement i to recheck the current index with the new element
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        int val = 3;
        int result = Occurrences(arr, val);

        if (result == 0) {
            System.out.println("Element is not present in the array");
        } else {
            System.out.println("Occurrences removed: " + result);
            System.out.print("Array after removing occurrences: ");
            for (int i = 0; i < arr.length - result; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
