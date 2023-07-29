/*
Given an integer array of coins[ ] of size N representing different types of currency and an integer sum, The task is to find the number of ways to make sum by using different combinations from coins[].
Note: Assume that you have an infinite supply of each type of coin.

Examples:
Input: sum = 4, coins[] = {1,2,3},
Output: 4
Explanation: there are four solutions: {1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}.
 */
public class _7_Coin_Change_Problem {
    public static int countWays(int[] coins,int n,int sum){
        int[] table=new int[sum+1];
        table[0]=1;
        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=sum;j++){
                table[j]+=table[i-coins[i]];
            }
        }
        return table[sum];
    }
    public static void main(String[] args) {
        int[] coins={1,2,3};
        int sum=4;
        System.out.println(countWays(coins,coins.length,sum));
    }
}
