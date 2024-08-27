class Pair {
    long distance;
    long node;

    public Pair(long distance, long node) {
        this.distance = distance;
        this.node = node;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        // Create the adjacency list for the graph
        ArrayList<ArrayList<Pair>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Populate the adjacency list with the given roads
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            long w = road[2];
            adjacencyList.get(u).add(new Pair(w, v));
            adjacencyList.get(v).add(new Pair(w, u)); // Since the graph is undirected
        }

        // Initialize the priority queue for Dijkstra's algorithm
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((a, b) -> Long.compare(a.distance, b.distance));

        // Distance and ways arrays
        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        // Add the source node to the priority queue
        priorityQueue.add(new Pair(0, 0));

        int mod = (int) (1e9 + 7);

        // Process nodes with Dijkstra's algorithm
        while (!priorityQueue.isEmpty()) {
            Pair current = priorityQueue.poll();
            long currentDist = current.distance;
            int node = (int) current.node;

            for (Pair neighbor : adjacencyList.get(node)) {
                int adjNode = (int) neighbor.node;
                long edgeWeight = neighbor.distance;

                if (currentDist + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = currentDist + edgeWeight;
                    priorityQueue.add(new Pair(dist[adjNode], adjNode));
                    ways[adjNode] = ways[node];
                } else if (currentDist + edgeWeight == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return (int) (ways[n - 1] % mod);
    }
}
