class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, grid[0][0]});
        int[][] minSum = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }
        minSum[0][0] = grid[0][0];
        int[][] directions = {{0, 1}, {1, 0}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int currentSum = current[2];

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                    int newSum = currentSum + grid[newX][newY];

                    if (newSum < minSum[newX][newY]) {
                        minSum[newX][newY] = newSum;
                        queue.offer(new int[]{newX, newY, newSum});
                    }
                }
            }
        }
        return minSum[rows - 1][cols - 1];
    }
}
