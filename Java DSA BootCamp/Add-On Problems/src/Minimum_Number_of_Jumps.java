/*
Given an array of integers where each element represents the max number of steps that can be made forward from that element. Find the minimum number of jumps to reach the end of the array (starting from the first element).
If an element is 0, then you cannot move through that element.
 */
public class Minimum_Number_of_Jumps {
    public static int jumps(int[] arr){
        int max=0,halt=0,jump=0;
        if(arr[0]==0){ // we cannot reach the answer
            return -1;
        }
        for(int i=0;i<arr.length-1;i++){
            max=Math.max(max,arr[i]+i);
            if(max>=arr.length-1){
                jump++;
                return jump;
            }
            if(i==halt){
                halt=max;
                jump++;
            }
        }
        if(halt>=arr.length-1){ // If the first index+value is huge enough to calculate the answer
            return jump;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1,3,5,8,9,2,6,8,2,9,10};
        System.out.println(jumps(arr));
    }
}
