class Solution {
    public int splitArray(int[] nums, int m) {
        int start = 0;
            int end = 0;

            for(int i = 0; i < nums.length; i++){
                start = Math.max(start, nums[i]); // This will contain the max item from the array.
                end += nums[i]; // Sum of the array as the end
            }

            // apply binary search
            while (start < end) {
                // try for the middle as the potiential ans
                int mid = start + (end - start) / 2;

                // Calc the no. of peices it can be divided into
                int sum = 0;
                int peices = 1;

                for (int num : nums) {
                    if(sum + num > mid){
                        // cannot be added to subarray
                        // if added and comes out equal to sum
                        sum = num;
                        peices ++;
                    } else {
                        sum += num;
                    }
                }

                if(peices > m){
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            return end;
    }
}