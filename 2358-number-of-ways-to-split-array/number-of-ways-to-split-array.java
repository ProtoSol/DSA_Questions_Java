class Solution {
    public int waysToSplitArray(int[] nums) {
        // Prefix Array
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        // Prefix Array Calculation
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int validSplits = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            long leftPart = prefix[i];
            long rightPart = prefix[prefix.length - 1] - prefix[i];
            if (leftPart >= rightPart) {
                validSplits++;
            }
        }

        return validSplits;
    }
}