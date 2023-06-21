/*
💡 **Question 8**
You are given an integer array nums and an integer k.

In one operation, you can choose any index i where 0 <= i < nums.length and change nums[i] to nums[i] + x where x is an integer from the range [-k, k]. You can apply this operation at most once for each index i.

The score of nums is the difference between the maximum and minimum elements in nums.

Return the minimum score of nums after applying the mentioned operation at most once for each index in it.

**Example 1:**
Input: nums = [1], k = 0
Output: 0

**Explanation:** The score is max(nums) - min(nums) = 1 - 1 = 0.
 */
public class Score_After_Operations {
    public static int minDifference(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) {
            return 0; // If the array has 0 or 1 element, no operation is needed
        }

        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }

        if (k >= maxNum - minNum) {
            return 0; // If the range k is greater than or equal to the difference between the maximum and minimum elements, the minimum score is 0
        }

        int target = (maxNum + minNum) / 2; // Calculate the target value to minimize the score
        int minScore = maxNum - minNum;

        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = Math.max(prefixSum[i - 1], nums[i]);
        }

        suffixSum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = Math.max(suffixSum[i + 1], nums[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            int leftMax = prefixSum[i];
            int rightMax = suffixSum[i + 1];
            int newScore = Math.max(Math.abs(leftMax - target), Math.abs(rightMax - target));
            minScore = Math.min(minScore, newScore);
        }

        return minScore;
    }
    public static void main(String[] args) {
        int[] nums = {1};
        int k = 0;
        int result = minDifference(nums, k);
        System.out.println(result);
    }
}
