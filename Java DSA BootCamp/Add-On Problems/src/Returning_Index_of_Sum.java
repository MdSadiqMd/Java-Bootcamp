import java.util.Scanner;
/*
Given an array of integers numbs and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

**Example:**
Input: numbs = [2,7,11,15], target = 9
Output:[0,1]
 */
public class Returning_Index_of_Sum {
    public static int Sum(int arr[],int k){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==k){
                    return i+j;
                }
                else{
                    return -1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the Length of Array:");
        int n=sc.nextInt();
        System.out.println("Enter the Sum target:");
        int k=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the Elements of the Array:");
        for (int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        int result=Sum(arr,k);
        if(result==-1){
            System.out.println("Three Summation of Given Element is not possible");
        }
        else{
            System.out.println(result);
        }
    }
}
