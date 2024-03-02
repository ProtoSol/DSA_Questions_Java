class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int max_profit = 0;
        for (int i = 1; i < prices.length; i++){
            sum += prices[i] - prices[i-1];
            max_profit = Math.max(sum,max_profit);
            sum = Math.max(0,sum);
        }
        return max_profit;
    }
}