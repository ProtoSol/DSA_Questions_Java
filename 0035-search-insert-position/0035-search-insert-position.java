class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int ans = nums.length;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                ans = mid; // Update the answer to the current index
                end = mid - 1;
            }
        }
        return ans;
    }
}