import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        
        // Make an adjacency list for the reversed graph
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adjRev.add(new ArrayList<>());
        }
        
        // Make the indegree array
        int[] inDegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int it : graph[i]){
                // Reverse the node linking
                adjRev.get(it).add(i);
                inDegree[i]++;
            }
        }
        
        // Perform BFS in the reversed graph
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNode = new ArrayList<>();
        
        // Initialize the queue
        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        // Start the BFS
        while(!q.isEmpty()){
            int node = q.poll();
            safeNode.add(node);
            for(int it: adjRev.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0) q.add(it);
            }
        }
        
        Collections.sort(safeNode);
        return safeNode;
    }
}