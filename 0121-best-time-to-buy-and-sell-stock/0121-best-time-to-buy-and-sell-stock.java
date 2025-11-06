class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;           // overall maximum profit
        int minPriceIndex = 0;       // index of the minimum price seen so far

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > prices[minPriceIndex]) {
                // potential profit if sold today
                int profit = prices[i] - prices[minPriceIndex];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            } else {
                // found new minimum price
                minPriceIndex = i;
            }
        }

        return maxProfit;
    }
}
