class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create an Adjacent Matrix List
        List<List<Integer>> adjList = new ArrayList<>();
        
        // Fill the Adjacent List
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Traverse the Edge and fill the Adj List
        for (int[] edge : edges) {
            // As it is Not Directed Graph we add the vertex both way
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        // Create a boolean array to keep track of visited nodes
        boolean[] visited = new boolean[n];
        
        // Start DFS from the source
        return dfs(adjList, visited, source, destination);
    }
    
    private boolean dfs(List<List<Integer>> adjList, boolean[] visited, int current, int destination) {
        // If we've reached the destination, return true
        if (current == destination) {
            return true;
        }
        
        // Mark the current node as visited
        visited[current] = true;
        
        // Explore all neighbors of the current node
        for (int neighbor : adjList.get(current)) {
            if (!visited[neighbor]) {
                if (dfs(adjList, visited, neighbor, destination)) {
                    return true;
                }
            }
        }
        
        // If we've explored all paths from this node and haven't found the destination, return false
        return false;
    }
}