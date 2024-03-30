
            // }
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;

        for(int i: nums){
            // First Approach
            // int digit = countDigit(i);
            // if (digit%2==0){
                // count ++;

            // Second Aproach using the log
            if(((int)Math.log10(i)+1)%2==0) count++;
        }
        return count;
    }

    // private int countDigit(int n){
    //     int count = 0;
    //     while(n != 0){
    //         count++;
    //         n /= 10;
    //     }
    //     return count;
    // }
}