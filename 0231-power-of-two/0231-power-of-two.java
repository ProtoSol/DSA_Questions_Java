class Solution {
    public boolean isPowerOfTwo(int n) {
        // A number is a power of two if it has only one bit set in its binary representation.
        // So, if we do a bitwise AND of n and (n - 1), and the result is 0, then n is a power of two.
        return n > 0 && (n & (n - 1)) == 0;
    }
}