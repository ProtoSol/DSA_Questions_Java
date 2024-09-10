class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        // Base Cases
        if (n == 1) return arr[0];
        if (arr[0] != arr[1]) return arr[0];
        if (arr[n-1] != arr[n-2]) return arr[n-1];

        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // case for mid
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }
            // moving to right
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || 
                (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                low = mid + 1;
            }/*moving to left*/ else {
                high = mid - 1;
            }
        }
        return -1;
    }
}