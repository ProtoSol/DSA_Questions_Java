class Solution {
    public int largestAltitude(int[] gain) {
        int highestAlt = 0;
        int sum = 0;
        for(int i = 0; i < gain.length; i++){
            sum += gain[i];
            if(highestAlt < sum){
                highestAlt = sum;
            }
        }
        return highestAlt;
    }
}