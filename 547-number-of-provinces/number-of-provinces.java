class Solution {

    private void helper(int node, int[][] isConnected, boolean visited[]){
        // Recursive Call to connecct the neighbors.
        visited[node] = true;
        for(int i = 0; i < isConnected.length; i++){
            if(isConnected[node][i] == 1 && !visited[i]){
                // Connection is there and not visited
                helper(i, isConnected, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int countComponents = 0;
        boolean visited[] = new boolean[isConnected.length];
        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i]){
                // If not visited
                countComponents++;
                helper(i, isConnected, visited);
            }
        }
        return countComponents;
    }
}