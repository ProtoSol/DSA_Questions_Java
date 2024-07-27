class Solution {
    // Top Down
    private int[] memo;
    private int[] nums;

    public int rob(int[] nums) {
        this.nums = nums;
        this.memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robFrom(0);
    }

    private int robFrom(int i) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int result = Math.max(nums[i] + robFrom(i + 2), robFrom(i + 1));
        memo[i] = result;
        return result;
    }
}