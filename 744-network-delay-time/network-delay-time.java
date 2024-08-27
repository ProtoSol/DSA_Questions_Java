class Pair {
    int node;
    int time;

    Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build the graph
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        // Initialize Dijkstra's algorithm
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        pq.add(new Pair(k, 0));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int time = current.time;

            if (time > dist[node]) {
                continue;
            }

            for (Pair neighbor : graph.get(node)) {
                int nextNode = neighbor.node;
                int travelTime = neighbor.time;

                if (dist[node] + travelTime < dist[nextNode]) {
                    dist[nextNode] = dist[node] + travelTime;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        // Find the maximum delay time among all nodes
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // Not all nodes are reachable
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}