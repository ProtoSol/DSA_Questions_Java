class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return helper(m - 1, n - 1, dp);
    }
    private int helper(int row, int col, int[][] dp){
        // base case
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row < 0 || col < 0) {
            return 0;
        }
        // check if calculated
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        // perform recursion and memoize the result
        int up = helper(row - 1, col, dp);
        int left = helper(row, col - 1, dp);

        dp[row][col] = up + left;

        return dp[row][col];
    }
}