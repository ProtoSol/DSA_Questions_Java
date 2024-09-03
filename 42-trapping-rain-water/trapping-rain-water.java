class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];

        // Fill the leftMax array
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int totalWater = 0;
        int rightMax = height[n - 1];

        // Traverse from right to left, calculating rightMax on the fly
        for (int i = n - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);

            // Calculate water trapped using the minimum of leftMax and rightMax
            totalWater += Math.min(leftMax[i], rightMax) - height[i];
        }

        return totalWater;
    }
}
