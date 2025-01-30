class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while (end < n) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                max = Math.max(max, end - start + 1);
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }
}