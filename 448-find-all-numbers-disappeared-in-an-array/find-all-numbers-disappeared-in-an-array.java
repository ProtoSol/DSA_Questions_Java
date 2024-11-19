class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        // add the elements in the set
        for(int i = 0; i < n; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }
        }
        // create the result array
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }

        return result;
    }
}