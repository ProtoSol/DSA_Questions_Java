class Solution {
    public int trap(int[] height) {
        int total = 0;
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int leftMax = height[l];
        int rightMax = height[r];

        while (l <= r) {
            if (leftMax <= rightMax) {
                if (height[l] < leftMax) {
                    total += leftMax - height[l];
                } else {
                    leftMax = height[l];
                }
                l++;
            } else {
                if (height[r] < rightMax) {
                    total += rightMax - height[r];
                } else {
                    rightMax = height[r];
                }
                r--;
            }
        }

        return total;
    }
}