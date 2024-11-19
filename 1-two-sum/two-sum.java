class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int number = nums[i];
            int diff = target - number;

            if(map.containsKey(diff)){
                result[0] = map.get(diff);
                result[1] = i;
                return result;
            }

            map.put(nums[i], i);
        }
        return result;
    }
}