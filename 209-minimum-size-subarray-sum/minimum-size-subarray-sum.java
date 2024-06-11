class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        
        if(k <= 1){
            return 0;
        }
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int currentSum = 0;

        for(int right = 0; right < nums.length; right++){
            currentSum += nums[right];
            while (currentSum >= k) {
                minLen = Math.min(minLen, right - left + 1);
                currentSum -= nums[left];
                left ++;
            }
            
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}