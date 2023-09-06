/*
💡 An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is
monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.

**Example 1:**
Input: nums = [1,2,2,3]
Output: true
 */
public class Monotonic_or_Not {
    public static int Checking(int[] arr){
        int count=0;
        if(arr.length>1){
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>=arr[i+1]){
                    count++;
                } else if (arr[i]<=arr[i+1]) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr={1,2,2,3};
        int result=Checking(arr);
        if(result==arr.length-1){
            System.out.println("Monotonic");
        }
        else{
            System.out.println("Not-Monotonic");
        }
    }
}
