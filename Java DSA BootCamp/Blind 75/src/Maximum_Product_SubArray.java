public class Maximum_Product_SubArray {
    // All +ve -> ans: +ve
    // +ve, even -ve -> ans: +ve
    // +ve, odd -ve -> ans: -ve
    // zero -> ans: zero
    public static int maxProduct(int[] arr) { // If SubArray then think of sliding window(not this question), Manipulate the test cases write all possible test cases and think the approach, Write brute force and start decreasing an order of N in each step
        int prefix=1,suffix=1;
        for(int i=0;i<arr.length;i++){
            if(prefix==0) prefix=1; // If prefix becomes 0 then make it as 1
            prefix=prefix*arr[i];
            if(suffix==0) suffix=1; // If suffix becomes 0 then make it as 1
            suffix=suffix*arr[arr.length-1-i];
        }
        return Math.max(prefix,suffix);
    }
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{1,2,-3,0,-4,-5}));
    }
}
