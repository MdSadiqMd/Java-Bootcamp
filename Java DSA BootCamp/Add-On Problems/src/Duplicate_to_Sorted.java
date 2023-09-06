import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
💡 You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

**Example 1:**
Input: arr = [1,2,2,4]
Output: [2,3]
 */
public class Duplicate_to_Sorted {
    public static int[] findErrorNumbers(int[] nums) {
        int[] result = new int[2];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each number
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find the number that occurs twice and the missing number
        for (int i = 1; i <= nums.length; i++) {
            if (frequencyMap.containsKey(i)) {
                if (frequencyMap.get(i) == 2) {
                    result[0] = i; // Number that occurs twice
                }
            } else {
                result[1] = i; // Missing number
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        int[] result = findErrorNumbers(nums);
        System.out.println(Arrays.toString(result));
    }
}
