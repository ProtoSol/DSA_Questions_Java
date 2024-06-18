// Brute Force O(n^2)
// Space Complexity O(1)

// class Solution {
//     public int countNegatives(int[][] grid) {
//         int count = 0;
//         for(int row = 0; row < grid.length; row++){
//             for(int col = 0; col < grid[row].length; col++){
//                 if(grid[row][col] < 0){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

// Using the Sorted Hint We will be using the Binary Search

class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int row = 0; row < grid.length; row++){
            int firstNegIndex = findFirstNegativeIndex(grid[row]);
            if(firstNegIndex != -1){
                count += grid[row].length - firstNegIndex;
            }
        }
        return count;
    }

    private int findFirstNegativeIndex(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left < nums.length && nums[left] < 0 ? left : -1;
    }
}