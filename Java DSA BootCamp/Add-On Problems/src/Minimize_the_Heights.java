import java.util.Arrays;

/*
Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of each tower either by increasing or decreasing them by K only once. After modifying, height should be a non-negative integer.
Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.
 */
public class Minimize_the_Heights {
    public static int max(int[] arr,int k){
        int min=0,max=0,r=0;
        Arrays.sort(arr);
        r=arr[arr.length-1]-arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=k){
                max=Math.max(arr[i-1]+k,arr[arr.length-1]-k);
                min=Math.min(arr[i]-k,arr[0]+k);
                r=Math.min(r,max-min);
            } else {
                continue;
            }
        }
        return r;
    }
    public static void main(String[] args) {
       int[] arr={1,1,1,2,5,6,7,9,9,10};
       int k=4;
       System.out.println(max(arr,k));
    }
}
