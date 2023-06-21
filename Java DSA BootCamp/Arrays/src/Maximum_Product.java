/*
💡 Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Example 1:
Input: nums = [1,2,3]
Output: 6
 */
public class Maximum_Product {
    public static int product(int[] arr){
        int answer=0;
        if(arr.length==3){
            answer=arr[0]*arr[1]*arr[2];
        }
        if(arr.length>3){
            int largest1=arr[0];
            for(int i=1;i<arr.length;i++){
                largest1=Math.max(largest1,arr[i]);
            }
            int largest2=Integer.MIN_VALUE; //*****
            for(int i=1;i<arr.length;i++){
                if(arr[i]!=largest1){
                    largest2=Math.max(largest2,arr[i]);
                }
            }
            int largest3=Integer.MIN_VALUE;
            for(int i=1;i<arr.length;i++){
                if(arr[i]!=largest1 && arr[i]!=largest2){
                    largest3=Math.max(largest3,arr[i]);
                }
            }
            answer=largest1*largest2*largest3;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        int result=product(arr);
        System.out.println(result);
    }
}
