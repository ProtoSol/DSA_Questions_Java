class Solution {
    boolean[][] board;

    public int totalNQueens(int n) {
        board = new boolean[n][n]; // Fill with false by default
        return helper(0, n);
    }

    private boolean willIPlaceQueen(int row, int col) {
        // Above Row case
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // Left upper Diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        // Right Upper Diagonal
        for (int i = row, j = col; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }

        return true;
    }

    private int helper(int row, int n) {
        // Base Case
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            if (willIPlaceQueen(row, col)) {
                // place the Queen
                board[row][col] = true;
                count += helper(row + 1, n);
                // Backtrack (Stack Fall)
                board[row][col] = false;
            }
        }
        return count;
    }
}