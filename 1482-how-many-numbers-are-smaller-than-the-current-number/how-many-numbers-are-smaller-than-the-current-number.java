class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        // Create a copy of the original array
        int[] sortedNums = nums.clone();
        // Sort the copied array
        Arrays.sort(sortedNums);
        // Store the first occurrence index of each number in a hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(sortedNums[i])) {
                map.put(sortedNums[i], i);
            }
        }
        // Set the result array based on the hashmap
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = map.get(nums[i]);
        }
        return result;
    }
}