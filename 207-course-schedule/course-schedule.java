class Solution {
    public boolean canFinish(int N, int[][] prerequisites) {
        // Create the Adj List
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for(int i = 0; i < m; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        // Make the Indegree Array
        int[] inDegree = new int[N];
        for(int i = 0; i < N; i++){
            for(int it : adj.get(i)){
                inDegree[it]++;
            }
        }
        
        // Perform the Bfs
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        List<Integer> topo = new ArrayList<Integer>();
        // perform the while loop
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int it : adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0) q.add(it);
            }
        }
        return topo.size() == N;
    }
}