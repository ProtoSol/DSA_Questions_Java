class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // We have nums 1 which is size n + m
        // num 2 is smaller than num 1

        // Approach 1 merge the array, then sort it to produce the result.

        for(int i = 0; i < n; i++){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}