/*
Here in this problem consider four cases if all elements are positive,array has even numbered of negative elements,array has positive number of negative elements,array has a zero
 */
public class Maximum_Product_SubArray {
    public static int sum(int[] arr){
        int leftTraversalSum=1;
        int rightTraversalSum=1;
        int ans=Integer.MIN_VALUE;
        if(arr.length==1){
            return arr[0];
        }
        for(int i=0;i<arr.length-1;i++){
            if(leftTraversalSum==0){
                leftTraversalSum=1;
            }
            if(rightTraversalSum==0){
                rightTraversalSum=1;
            }
            leftTraversalSum=leftTraversalSum*arr[i];
            rightTraversalSum=rightTraversalSum*arr[i];
            ans=Math.max(ans,Math.max(leftTraversalSum,rightTraversalSum));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={2,3,-2,4};
        System.out.println(sum(arr));
    }
}
