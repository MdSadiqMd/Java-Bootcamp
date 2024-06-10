public class Kadane_Algorithm {
    public static int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<nums.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=nums[k];
                }
                max=Math.max(max,sum);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr={4,-1,2,1};
        System.out.println(maxSubArray(arr));
    }
}
