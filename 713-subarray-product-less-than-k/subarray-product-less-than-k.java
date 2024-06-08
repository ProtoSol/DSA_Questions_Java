class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {

        if(k <=1){
            return 0;
        }
        int count = 0;
        // We get two pointer setup
        int left = 0;
        int currentProd = 1;
        // Move till right
        for(int right = 0; right < arr.length; right++){
            currentProd = currentProd * arr[right];
            while(currentProd >= k){
                currentProd = currentProd/arr[left];
                left++;
            }
            count = count + right - left + 1;
        }
        return count;
    }
}