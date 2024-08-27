class Solution {
    private static final int[][] DIR = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        // BFS setup using Queue instead of Deque
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;  // Mark as visited and store the distance

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];
            int dist = grid[r][c];

            // Check if we reached the bottom-right corner
            if (r == n - 1 && c == n - 1) {
                return dist;
            }

            // Explore all 8 directions
            for (int[] dir : DIR) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];

                // Check bounds and whether the cell is unvisited (value 0)
                if (nextR >= 0 && nextC >= 0 && nextR < n && nextC < n && grid[nextR][nextC] == 0) {
                    queue.offer(new int[]{nextR, nextC});
                    grid[nextR][nextC] = dist + 1;  // Mark as visited and store the distance
                }
            }
        }

        return -1;  // No path found
    }
}