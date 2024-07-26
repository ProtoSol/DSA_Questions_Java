class Solution {
    // Compute the Calculation and add it to the Memo
    Map<Integer, Integer> memo = new HashMap<>();
    public int fib(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        // Before Calc check if Present in memo
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int first = fib(n-1);
        int second = fib(n-2);
        int third  = first + second;
        memo.put(n,third); // Store in the Cache
        return memo.get(n); // Return the value from the Cache
    }
}