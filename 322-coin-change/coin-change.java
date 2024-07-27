class Solution {

    // Time Limit Exceeds In Recursive
    // public int coinChange(int[] coins, int amount) {
        // if(amount < 0){
        //     return -1;
        // }
        // if(amount == 0){
        //     return 0;
        // }
        // int minCount = Integer.MAX_VALUE;
        // for(int coin : coins){
        //     int count = coinChange(coins, amount - coin);
        //     if(count == -1){
        //         continue;
        //     }
        //     minCount = Math.min(minCount, count + 1);
        // }
        // return minCount == Integer.MAX_VALUE?-1:minCount;
    // }

    // DP Top Down
    // public int coinChange(int[] coins, int amount) {
    //     int[] cache = new int[amount + 1];
    //     Arrays.fill(cache, -1);
    //     return coinChangeHelper(coins, amount, cache);
    // }

    // public int coinChangeHelper(int[] coins, int amount, int[] cache) {
    //     if (amount < 0) {
    //         return -1;
    //     }
    //     if (amount == 0) {
    //         return 0;
    //     }
    //     if (cache[amount] != -1) {
    //         return cache[amount];
    //     }

    //     int minCount = Integer.MAX_VALUE;
    //     for (int coin : coins) {
    //         int count = coinChangeHelper(coins, amount - coin, cache);
    //         if (count != -1) {
    //             minCount = Math.min(minCount, count + 1);
    //         }
    //     }

    //     cache[amount] = (minCount == Integer.MAX_VALUE) ? -1 : minCount;
    //     return cache[amount];
    // }

    // DP Bottom Up
    
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
