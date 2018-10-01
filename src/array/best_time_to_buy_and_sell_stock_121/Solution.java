package array.best_time_to_buy_and_sell_stock_121;


// 121
//
// Say you have an array for which the ith element is the price of a given stock on day i.
//
// If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//
// Note that you cannot sell a stock before you buy one.
public class Solution {

    // simple every-day buy-sell solution
    int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int currMin = prices[0];
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, (price - currMin));
            currMin = Math.min(currMin, price);
        }
        return maxProfit;
    }

}


