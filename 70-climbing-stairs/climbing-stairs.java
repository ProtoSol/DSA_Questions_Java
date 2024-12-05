class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    
    public int climbStairs(int n) {
        // O(n) time complexity O(n) space complexity
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        // int[] dp = new int[n+1];
        // dp[0] = 0;
        // dp[1] = 1;
        // dp[2] = 2;
        // for(int i = 3; i < n + 1; i++){
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        // return dp[n];

        int first = 1;
        int second = 2;
        for(int i = 3; i < n + 1; i++){
            int temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }
}