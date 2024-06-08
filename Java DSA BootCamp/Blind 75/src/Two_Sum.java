import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum {
    public static int[] twoSum(int[] nums,int target){ // TC:O(n),SC:O(n)
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<=nums.length-1;i++){
            int search=target-nums[i];
            if(map.containsKey(search)) return new int[]{nums[i],i};
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
    public static int[] twoSumBinary(int[] nums,int target){ // TC:O(N)+O(N*log(N)),SC:O(1)
        Arrays.sort(nums);
        int left=0,right=1;
        for(int i=0;i<=nums.length-1;i++){
            int search=nums[left]+nums[right];
            if(search==target) return new int[]{nums[left],nums[right]};
            else if(search<target) left++;
            else right--;
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] arr={2,6,5,8,11};
        System.out.println(Arrays.toString(twoSum(arr,7)));
        System.out.println(Arrays.toString(twoSumBinary(arr,7)));
    }
}
