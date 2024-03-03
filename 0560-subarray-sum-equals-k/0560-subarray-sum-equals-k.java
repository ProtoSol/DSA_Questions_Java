class Solution {
    public int subarraySum(int[] nums, int k) {
        int preSum = 0;
        int cnt = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        // Intitalization of Variables
        // Running the logic (HashMap)
        for(int i = 0; i < nums.length; i++){
            preSum += nums[i];
            int remove = preSum - k;

            cnt = cnt + mpp.getOrDefault(remove,0);
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        // O(N x log N) - Time
        // O(N) - Space
        return cnt;
    }
}