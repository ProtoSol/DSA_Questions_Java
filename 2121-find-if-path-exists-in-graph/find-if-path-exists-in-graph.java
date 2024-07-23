class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create an Adjacent Matrix List
        List<List<Integer>> adjList = new ArrayList<>();
        // Fill the Adjacent List
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // now we Traverse the Edge and fill the Adj List
        for (int[] edge : edges) {
            // As it is Not Directed Graph we add the vertex both way
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // As we have the Adj List now we Traverse using any of the DFS / BFS
        // We are using DFS in iterative way
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        boolean[] visited = new boolean[n];
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (node == destination) {
                return true;
            }
            if (!visited[node]) {
                visited[node] = true;
                // Explore the Neighbours
                for (int neighbour : adjList.get(node)) {
                    stack.push(neighbour);
                }
            }
        }
        return false;
    }
}