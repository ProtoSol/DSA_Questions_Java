import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // this is a two pointer question
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        // sort the array to apply two-pointer technique
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            // avoid duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // we select the first number
            int first = nums[i];
            // we select the two pointers
            int second = i + 1;
            int third = n - 1;

            while (second < third) {
                int sum = first + nums[second] + nums[third];
                if (sum == 0) {
                    // add the triplet to the result
                    result.add(Arrays.asList(first, nums[second], nums[third]));
                    // move pointers to avoid duplicates
                    while (second < third && nums[second] == nums[second + 1]) {
                        second++;
                    }
                    while (second < third && nums[third] == nums[third - 1]) {
                        third--;
                    }
                    second++;
                    third--;
                } else if (sum < 0) {
                    // move the second pointer to increase the sum
                    second++;
                } else {
                    // move the third pointer to decrease the sum
                    third--;
                }
            }
        }
        return result;
    }
}
