/*
Given an array of integers where each element represents the max number of steps that can be made forward from that element. Find the minimum number of jumps to reach the end of the array (starting from the first element).
If an element is 0, then you cannot move through that element.
 */
public class Minimum_Number_of_Jumps {
    public static int jumps(int[] arr){
        int ans=0;
        for(int i=0;i<arr.length-1;i++){
            int k=arr[0];
            for(int j=1;j<arr[0]-1;j++){
                ans=Math.max(arr[j]+j,arr[j+1]+j+1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,3,5,8,9,2,6,8,2,9,10};
        System.out.println(jumps(arr));
    }
}
