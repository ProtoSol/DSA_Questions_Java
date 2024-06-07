class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] result = { -1, -1 };

        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            int diff = target - num;

            if (mpp.containsKey(diff)) {
                result[0] = mpp.get(diff);
                result[1] = i;
                return result;
            }
            
            mpp.put(nums[i], i);
        }
        
        return result;
    }
}