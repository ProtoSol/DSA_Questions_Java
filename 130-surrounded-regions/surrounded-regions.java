class Solution {

    private void dfs(int row, int col, int[][] vis, char[][] board, int[] delrow, int[] delcol) {
        vis[row][col] = 1; 
        int n = board.length;
        int m = board[0].length;

        // Check for top, right, bottom, left 
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i]; 
            // Check for valid coordinates and unvisited 'O's
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, board, delrow, delcol); 
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) return;
        int m = board[0].length;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        int[][] vis = new int[n][m];

        // Traverse first row and last row 
        for (int j = 0; j < m; j++) {
            // Check for unvisited 'O's in the boundary rows
            // First row 
            if (vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, vis, board, delrow, delcol); 
            }

            // Last row 
            if (vis[n-1][j] == 0 && board[n-1][j] == 'O') {
                dfs(n-1, j, vis, board, delrow, delcol); 
            }
        }

        // Traverse first column and last column 
        for (int i = 0; i < n; i++) {
            // Check for unvisited 'O's in the boundary columns
            // First column 
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, vis, board, delrow, delcol); 
            }

            // Last column
            if (vis[i][m-1] == 0 && board[i][m-1] == 'O') {
                dfs(i, m-1, vis, board, delrow, delcol); 
            }
        }

        // Convert all unvisited 'O's to 'X's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X'; 
                }
            }
        }
    }
}
