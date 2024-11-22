class Solution {
    public int[] sortedSquares(int[] nums) {
        // Square the values
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            result[i] = nums[i]*nums[i];
        }
        // Sort the result
        Arrays.sort(result);
        // Submit the Result
        return result;
    }
}