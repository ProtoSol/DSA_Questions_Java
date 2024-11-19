class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        // Add elements to the set in a single loop
        for (int num : nums) {
            set.add(num);
        }
        // Create the result list by checking for missing numbers
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}