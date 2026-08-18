import java.util.Arrays;

class Assgn3_2 {
    static final int INF = 1000000;
    static final int V = 4;
    static final char[] nodeNames = {'A', 'B', 'C', 'D'};

    // Adjacency Matrix representing the network graph
    static final int[][] graph = {
        {0, 2, INF, 1}, // A
        {2, 0, 3, 7}, // B
        {INF, 3, 0, 11}, // C
        {1, 7, 11, 0} // D
    };

    public static void dijkstra(int src) {
        int[] dist = new int[V];
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = -1;
            for (int i = 0; i < V; i++) {
                if (!visited[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }

            if (dist[u] == INF) break;
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        printRoutingTable(src, dist, parent);
    }

    private static void printRoutingTable(int src, int[] dist, int[] parent) {
        System.out.println("=== Final Routing Table for Node " + nodeNames[src] + " ===");
        System.out.printf("%-15s %-12s %-10s%n", "Destination", "Distance", "Next Hop");
        System.out.println("---------------------------------------");

        for (int i = 0; i < V; i++) {
            String nextHop;
            if (i == src) {
                nextHop = String.valueOf(nodeNames[src]);
            } else if (dist[i] == INF) {
                nextHop = "-";
            } else {
                int curr = i;
                while (parent[curr] != -1 && parent[curr] != src) {
                    curr = parent[curr];
                }
                nextHop = String.valueOf(nodeNames[curr]);
            }

            String distStr = (dist[i] == INF) ? "INF" : String.valueOf(dist[i]);
            System.out.printf("%-15s %-12s %-10s%n", nodeNames[i], distStr, nextHop);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0; i < V; i++) {
            dijkstra(i);
        }
    }
}