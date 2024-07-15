public class Maximum_SubArray {
    public static int maxSubArray(int[] arr){
        int ans=0,sum=arr[0];
        for(int i=1;i<arr.length;i++){
            sum+=arr[i];
            if(sum>ans) ans=sum;
            if(sum<0) sum=0;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
