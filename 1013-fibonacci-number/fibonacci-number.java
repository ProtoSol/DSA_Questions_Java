class Solution {
    // Bottom Up
    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n+1];
        // Take care of the Base Case
        // dp[0] = 0;
        dp[1] = 1;
        // Iterate through the array
        for(int i = 2; i <= n; i++){
            int firstTerm = dp[i-1];
            int secondTerm = dp[i-2];
            int thirdTerm = firstTerm + secondTerm;
            dp[i] = thirdTerm;
        }
        return dp[n];
    }
}