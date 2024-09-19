class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = findMax(weights);
        int high = sum(weights);
        while(low <= high){
            int mid = (low + high)/2;
            int numberOfDays = findDays(weights, mid);
            if(numberOfDays <= days){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int findDays(int[] weights, int cap){
        int days = 1, load = 0;
        for(int i = 0; i < weights.length; i++){
            if(weights[i] + load  > cap){
                days += 1;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }
        return days;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}