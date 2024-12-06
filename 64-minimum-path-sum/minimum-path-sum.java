class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] memo = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                memo[i][j] = -1;
            }
        }

        return dfs(grid, 0, 0, memo);
    }

    private int dfs(int[][] grid, int row, int col, int[][] memo) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row == rows - 1 && col == cols - 1) {
            return grid[row][col];
        }
        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        int minSum = Integer.MAX_VALUE;

        if (row + 1 < rows) {
            minSum = Math.min(minSum, dfs(grid, row + 1, col, memo));
        }
        if (col + 1 < cols) {
            minSum = Math.min(minSum, dfs(grid, row, col + 1, memo));
        }
        memo[row][col] = grid[row][col] + minSum;
        return memo[row][col];
    }
}
