class Solution {
    public int longestConsecutive(int[] nums) {
        // Intialize a hashset
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        // Loop through the elements in the array
        int maxCount = 0;
        for (int i : set) {
            int count = 0;
            int num = i;
            if (!set.contains(num - 1)) {
                while (set.contains(num)) {
                    count++;
                    num++;
                }
                 maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}