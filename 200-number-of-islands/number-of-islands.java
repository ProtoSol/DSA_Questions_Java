class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfsHelper(i, j, grid);
                }
            }
        }
        
        return numIslands;
    }
    
    private void dfsHelper(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        
        grid[row][col] = '0';  // Mark as visited
        
        // Recursively explore adjacent cells
        dfsHelper(row + 1, col, grid);  // Down
        dfsHelper(row - 1, col, grid);  // Up
        dfsHelper(row, col + 1, grid);  // Right
        dfsHelper(row, col - 1, grid);  // Left
    }
}