class Solution {
    public int longestMountain(int[] arr) {
        int result = 0;

        for(int i = 1; i < arr.length - 1; i++){
            if(arr[i-1] < arr[i] && arr[i] > arr[i + 1]){
                int l = i;
                int r = i;
                while(l > 0 && arr[l] > arr[l-1]){
                    l--;
                }
                while(r < arr.length - 1 && arr[r] > arr[r+1]){
                    r++;
                }
                result = Math.max(result, r - l + 1);
            }
        }

        return result;
    }
}