class Solution {
    public boolean isSubsequence(String s, String t) {
        
       if (s.length() == 0) return true;
        if (s.length() > t.length()) return false;

        int sPointer = 0;
        int tPointer = 0;

        while (tPointer < t.length()){
            if (t.charAt(tPointer) == s.charAt(sPointer)){
                sPointer++;
                if (sPointer == s.length()) return true;
            }
            tPointer++;
        }
        return false;

    }
}