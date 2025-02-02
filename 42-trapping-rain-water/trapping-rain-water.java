class Solution {
    public int trap(int[] height) {
        int total = 0;
        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                total += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                total += rightMax - height[right];
                right--;
            }
        }

        return total;
    }
}