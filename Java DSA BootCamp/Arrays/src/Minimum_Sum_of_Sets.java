import java.util.*;
/*
💡 Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2),..., (an, bn) such that the sum of min(ai, bi) for all I is maximized. Return the maximized sum.

**Example 1:**
Input: nums = [1,4,3,2]
Output: 4

**Explanation:** All possible pairings (ignoring the ordering of elements) are:

1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
So the maximum possible sum is 4
 */
public class Minimum_Sum_of_Sets {
    public static int Sum(int[] arr){
        int sum=0;
        for(int i=0;i<(arr.length/2);i++){
            sum=sum+(arr[2*i]);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr={1,4,3,2};
        int result=Sum(arr);
        System.out.println(result);
    }
}
