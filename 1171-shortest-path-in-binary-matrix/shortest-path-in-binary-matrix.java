class Pair {
    int x;
    int y;
    int distance;

    Pair(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Check if the start or end point is blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        // Directions for 8 possible movements
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1}, 
            {0, -1}, {0, 1}, 
            {1, -1}, {1, 0}, {1, 1}
        };

        // PriorityQueue for Dijkstra's algorithm, storing Pair (x, y, distance)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Pair(0, 0, 1)); // Start from the top-left corner with path length 1

        // Visited matrix to track visited cells
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int x = current.x;
            int y = current.y;
            int dist = current.distance;

            // If we've reached the bottom-right corner, return the path length
            if (x == n - 1 && y == n - 1) {
                return dist;
            }

            // Explore all 8 directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newY >= 0 && newX < n && newY < n && grid[newX][newY] == 0 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    pq.add(new Pair(newX, newY, dist + 1));
                }
            }
        }

        // If no path found, return -1
        return -1;
    }
}