class Solution {
    public boolean check(int[] nums) {
        // We need a counter
        int n = nums.length;
        int count = 0;

        // check the first case
        if(nums[0] < nums[n - 1]){
            count++;
        }
        for(int i = 0; i < n - 1; i++){
            if(nums[i] > nums[i + 1]){
                count++;
            }
            if(count > 1) return false;
        }

        return true;
    }
}