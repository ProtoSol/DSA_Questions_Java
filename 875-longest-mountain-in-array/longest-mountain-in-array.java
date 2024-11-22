class Solution {
    public int longestMountain(int[] arr) {
        int result = 0;
        // two pointer approach
        for(int i = 1; i < arr.length - 1; i++){
            if(arr[i-1] < arr[i] && arr[i] > arr[i + 1]){
                // set two pointers
                int l = i;
                int r = i;
                // move the pointers
                while(l > 0 && arr[l] > arr[l-1]){
                    l--;
                }
                while(r < arr.length - 1 && arr[r] > arr[r+1]){
                    r++;
                }
                // get the max mountain range
                result = Math.max(result, r - l + 1);
            }
        }
        // return the result
        return result;
    }
}