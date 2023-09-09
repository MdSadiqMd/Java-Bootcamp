import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the input array first.

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate values to avoid duplicate triplets.
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate values on both sides.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move to the next unique pair.
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(arr);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
