/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class Buy_and_Sell_Stock {
    public static int maxProfit(int[] arr){
        int min=arr[0];
        int max=0;
        for(int i=1;i<arr.length;i++){
            int cost=arr[i]-min;
            max=Math.max(max,cost);
            min=Math.min(min,arr[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr={7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
