class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        // if length = 0
        if (n == 0) {
            return nums;
        }
        // if array contains only positive
        int[] result = new int[n];
        if (nums[0] > 0) {
            for (int i = 0; i < n; i++) {
                result[i] = nums[i] * nums[i];
            }
            return result;
        }
        // if array contains only negative
        if (nums[n - 1] < 0) {
            for (int i = 0; i < n; i++) {
                result[i] = nums[n - 1 - i] * nums[n - 1 - i];
            }
            return result;
        }
        // find the first positive
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                m = i;
                break;
            }
        }
        // apply the two-pointer approach for merging
        int left = m - 1; // pointer for negative numbers
        int right = m;    // pointer for non-negative numbers
        int idx = 0;      // index for result array

        while (left >= 0 && right < n) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                result[idx++] = nums[left] * nums[left];
                left--;
            } else {
                result[idx++] = nums[right] * nums[right];
                right++;
            }
        }
        // if there are remaining negative numbers
        while (left >= 0) {
            result[idx++] = nums[left] * nums[left];
            left--;
        }
        // if there are remaining non-negative numbers
        while (right < n) {
            result[idx++] = nums[right] * nums[right];
            right++;
        }
        return result;
    }
}
