class Solution {
    public int edgeScore(int[] edges) {
        long[] edgeSum = new long[edges.length];

        for(int i = 0; i < edges.length; i++){
            int to = edges[i];
            edgeSum[to] += i;
        }

        int minEdge = -1;
        long maxSum = -1;
        for(int i = 0; i < edgeSum.length; i++){
            long currSum = edgeSum[i];
            if(currSum > maxSum){
                maxSum = currSum;
                minEdge = i;
            }
        }

        return minEdge;
    }
}