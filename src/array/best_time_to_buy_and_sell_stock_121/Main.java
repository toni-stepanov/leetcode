package array.best_time_to_buy_and_sell_stock_121;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        //int[] nums = {6,5,5,7,9,9,6,4,3,5,7,6};
        int[] nums = {111,2,0,1,7};
        int profit = s.maxProfit(nums);
        System.out.print(profit);
    }
}


