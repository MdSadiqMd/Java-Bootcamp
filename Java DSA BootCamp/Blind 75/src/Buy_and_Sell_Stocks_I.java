public class Buy_and_Sell_Stocks_I {
    public static int maxProfit(int[] prices){ // TC:O(n^2),SC:O(1)
        int profit=0;
        for(int i=0;i<=prices.length-1;i++){
            for(int j=i+1;j<=prices.length-1;j++){
                profit=Math.max(profit,prices[j]-prices[i]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr={7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
