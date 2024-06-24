class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int minInc = 0;
        for(int i = 1; i < nums.length; i ++){
            // Compare with prev
            if(nums[i] <= nums[i-1]){
                int inc = nums[i - 1] - nums[i] + 1;
                minInc = minInc + inc;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return minInc;
    }
}