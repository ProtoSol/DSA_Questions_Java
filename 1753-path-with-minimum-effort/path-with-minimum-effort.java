import java.util.PriorityQueue;

public class Info {
    int x;
    int y;
    int effort;
    public Info(int x, int y, int effort) {
        this.x = x;
        this.y = y;
        this.effort = effort;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Info> q = new PriorityQueue<>((a, b) -> Integer.compare(a.effort, b.effort));
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] effortTo = new int[rows][cols];
        // Initialize effort array with Integer.MAX_VALUE
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                effortTo[i][j] = Integer.MAX_VALUE;
            }
        }
        // Starting point
        q.add(new Info(0, 0, 0));
        effortTo[0][0] = 0;
        // Direction vectors for exploring all 4 directions (right, left, down, up)
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            Info info = q.poll();
            int r = info.x;
            int c = info.y;
            int currentEffort = info.effort;
            // If we reach the bottom-right corner, return the effort
            if (r == rows - 1 && c == cols - 1) {
                return currentEffort;
            }
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                // Check if new position is within bounds
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newEffort = Math.max(currentEffort, Math.abs(heights[newRow][newCol] - heights[r][c]));
                    // If the new effort is less than previously recorded effort, update and add to the queue
                    if (newEffort < effortTo[newRow][newCol]) {
                        effortTo[newRow][newCol] = newEffort;
                        q.add(new Info(newRow, newCol, newEffort));
                    }
                }
            }
        }
        return -1;
    }
}