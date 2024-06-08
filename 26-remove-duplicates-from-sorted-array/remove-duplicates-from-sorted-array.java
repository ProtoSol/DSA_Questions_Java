class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){} else{
                len++;
                nums[len] = nums[i];
            }
        }
        return (len+1);
    }
}