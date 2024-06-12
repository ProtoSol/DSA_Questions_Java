class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // We have nums 1 which is size n + m
        // num 2 is smaller than num 1

        // Approach 1 merge the array, then sort it to produce the result.

        // for(int i = 0; i < n; i++){
        //     nums1[m+i] = nums2[i];
        // }
        // Arrays.sort(nums1);

        // Approach 2

        // We will use Three Pointer Approach
        // Two pointers to read, one for writing

        int[] result = new int[m + n];

        int firstArrayPointer = 0;
        int secondArrayPointer = 0;
        int resultPointer = 0;

        while (firstArrayPointer < m && secondArrayPointer < n) {
            if (nums1[firstArrayPointer] <= nums2[secondArrayPointer]) {
                result[resultPointer] = nums1[firstArrayPointer];
                firstArrayPointer++;
            } else {
                result[resultPointer] = nums2[secondArrayPointer];
                secondArrayPointer++;
            }
            resultPointer++;
        }

        // Copy remaining elements from nums1
        while (firstArrayPointer < m) {
            result[resultPointer] = nums1[firstArrayPointer];
            firstArrayPointer++;
            resultPointer++;
        }

        // Copy remaining elements from nums2
        while (secondArrayPointer < n) {
            result[resultPointer] = nums2[secondArrayPointer];
            secondArrayPointer++;
            resultPointer++;
        }

        // Copy merged array back to nums1
        System.arraycopy(result, 0, nums1, 0, m + n);
    }
}