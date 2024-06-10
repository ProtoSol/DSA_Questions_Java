class Solution {
    public double findMaxAverage(int[] arr, int k) {
        if(k > arr.length){
            return -1;
        }

        // Initializing the Result
        double maxAverage = Double.MIN_VALUE;

        // Sum of the first K size window
        double sum = 0;

        for (int i = 0; i < k; i++){
            sum += arr[i];
        }

        maxAverage = sum / k;

        // Remaining window size
        for(int i =k; i < arr.length; i++){
            sum = sum - arr[i-k] + arr[i];
            maxAverage = Math.max(maxAverage, sum / k);
        }

        // Return the Answer
        return maxAverage;
    }
}