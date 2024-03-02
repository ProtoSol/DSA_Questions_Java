class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] newArray = new int[nums.length];
        for (int i = 0, x = 0, j = n; i < (n * 2); i += 2, j++, x++) {
            newArray[i] = nums[x];
            newArray[i + 1] = nums[j];
        }
        return newArray;
    }
}