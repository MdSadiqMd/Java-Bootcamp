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
    // Eliminating an extra for loop whose job is to check the min thus you can check min in this way also
    public static int maxProfitOptimise(int[] prices){ // TC:O(n),SC:O(1)
        int profit=0,buy=prices[0];
        for(int sell=0;sell<=prices.length-1;sell++){
            if(buy>prices[sell]) buy=prices[sell];
            else profit=Math.max(profit,prices[sell]-buy);
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] arr={7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
        System.out.println(maxProfitOptimise(arr));
    }
}
