import java.util.*;
/*
💡 We define a harmonious array as an array where the difference between its maximum value
and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence
among all its possible subsequences.

A subsequence of an array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.

Example 1:
Input: nums = [1,3,2,2,5,2,3,7]
Output: 5

Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 */

public class Harmonious_Array {
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int result = 0;

        // Count the frequency of each number
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Find the longest harmonious subsequence
        for (int num : countMap.keySet()) {
            if (countMap.containsKey(num + 1)) {
                int currentLen = countMap.get(num) + countMap.get(num + 1);
                result = Math.max(result, currentLen);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        int result = findLHS(nums);
        System.out.println(result);
    }
}

