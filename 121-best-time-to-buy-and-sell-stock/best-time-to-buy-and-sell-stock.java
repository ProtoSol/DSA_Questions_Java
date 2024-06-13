class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Update minPrice to the lowest price seen so far
            minPrice = Math.min(minPrice, prices[i]);
            // Calculate the potential profit if we sold at the current price
            int profit = prices[i] - minPrice;
            // Update maxProfit if the current profit is greater than the previously recorded maxProfit
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}