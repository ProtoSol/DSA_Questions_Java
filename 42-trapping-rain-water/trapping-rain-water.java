class Pair {
    int leftMax;
    int value;
    int rightMax;

    public Pair(int a, int b, int c) {
        this.leftMax = a;
        this.value = b;
        this.rightMax = c;
    }
}

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        // Create an array of Pairs to store leftMax, value, and rightMax
        Pair[] pairs = new Pair[n];

        // Calculate leftMax for each position
        int leftMax = 0;
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            pairs[i] = new Pair(leftMax, height[i], 0); // rightMax is 0 for now
        }

        // Calculate rightMax for each position
        int rightMax = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            pairs[i].rightMax = rightMax;
        }

        // Calculate the total water trapped
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            // Water trapped at each position is determined by the minimum of leftMax and rightMax, minus the height
            int waterTrapped = Math.min(pairs[i].leftMax, pairs[i].rightMax) - pairs[i].value;
            if (waterTrapped > 0) {
                totalWater += waterTrapped;
            }
        }

        return totalWater;
    }
}
