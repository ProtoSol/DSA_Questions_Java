class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int[] count = new int[26];
        int left = 0;
        int right = 0;
        int maxOccured = 0;

        for(;right<s.length();right++){
            maxOccured = Math.max(maxOccured, ++count[s.charAt(right) - 'A']);
            if(right - left + 1 - maxOccured > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}