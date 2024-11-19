class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        int n = points.length;

        for (int i = 1; i < n; i++) {
            int x1 = points[i - 1][0], y1 = points[i - 1][1];
            int x2 = points[i][0], y2 = points[i][1];
            res += Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
        }

        return res;
    }
}