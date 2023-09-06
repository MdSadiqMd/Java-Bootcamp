import java.util.*;
/*
💡 Given an integer array nums of length n and an integer target, find three integers
in nums such that the sum is closest to the target.
Return the sum of the three integers.

You may assume that each input would have exactly one solution.

**Example 1:**
Input: nums = [-1,2,1,-4], target = 1
Output: 2

**Explanation:** The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 */
import java.util.Arrays;
import java.util.Scanner;

public class Closest_Three_Sum {
    public static int closestThreeSum(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array in ascending order
        int closestSum = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int currentDiff = Math.abs(sum - target);

                if (currentDiff < diff) {
                    diff = currentDiff;
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] nums = {-1, 2, 1, -4};
        int result = closestThreeSum(nums, target);
        System.out.println(result);
    }
}

