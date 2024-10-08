class Solution {

    private int longestCycle(int i, int[] edges, int step, int[] visited, Map<Integer, Integer> nodeToStep) {
        if (edges[i] == -1) {
            return -1;
        }
        if (nodeToStep.containsKey(i)) {
            return step - nodeToStep.get(i);
        }
        if (visited[i] == 1) {
            return -1;
        }
        
        visited[i] = 1;
        nodeToStep.put(i, step);
        return longestCycle(edges[i], edges, step + 1, visited, nodeToStep);
    }
    

    public int longestCycle(int[] edges) {
        int maxCycle = -1;
        int[] visited = new int[edges.length];

        for (int i = 0; i < edges.length; i++) {
            if (visited[i] == 1 || edges[i] == -1) {
                continue;
            }
            int cycle = longestCycle(i, edges, 0, visited, new HashMap<>());
            if (cycle > maxCycle) maxCycle = cycle;
        }

        return maxCycle;
    }
}