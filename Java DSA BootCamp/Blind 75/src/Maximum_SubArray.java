public class Maximum_SubArray {
    public static int maxSubArray(int[] arr){ // Target is Maximum so think a way to eliminate less than zero (second for loop) and keep variables concise with default values, There is also another way to keep up with max (first for loop)
        int ans=Integer.MIN_VALUE,sum=0;
        for(int j:arr){
            sum+=j;
            if(sum>ans) ans=sum;
            if(sum<0) sum=0;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
