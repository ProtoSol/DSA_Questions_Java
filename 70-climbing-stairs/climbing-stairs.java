class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    
    public int climbStairs(int n) {
        // Base cases
        if (n <= 1) {
            return 1;
        }
        
        // Check if we've already computed this value
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        // Recursive calculation with memoization
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        
        // Store the result in our memo before returning
        memo.put(n, result);
        
        return result;
    }
}