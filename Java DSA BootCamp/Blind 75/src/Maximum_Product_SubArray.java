public class Maximum_Product_SubArray {
    // All +ve -> ans: +ve
    // +ve, even -ve -> ans: +ve
    // +ve, odd -ve -> ans: -ve
    // zero -> ans: zero
    public static int maxProduct(int[] arr) { // If SubArray then think of sliding window(not this question), Manipulate the test cases write all possible test cases and think the approach, Write brute force and start decreasing an order of N in each step
        double prefix=1,suffix=1,ans=arr[0]; // Use this rather Integer.MIN_VALUE for this question as nothing had mentioned to return as default value something should be returned by yourselves
        for(int i=0;i<arr.length;i++){
            if(prefix==0) prefix=1; // If prefix becomes 0 then make it as 1
            if(suffix==0) suffix=1; // If suffix becomes 0 then make it as 1
            prefix=prefix*arr[i];
            suffix=suffix*arr[arr.length-1-i];
            ans=Math.max(ans,Math.max(prefix,suffix));
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0}));
    }
}
