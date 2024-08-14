class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create the adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            adj.get(prereq[1]).add(prereq[0]);
        }
        
        // Create the indegree array
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }
        
        // Perform BFS
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        
        int[] topo = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[index++] = node;
            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) q.add(it);
            }
        }
        
        return (index == numCourses) ? topo : new int[0];
    }
}