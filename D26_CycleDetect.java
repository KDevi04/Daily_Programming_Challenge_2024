import java.util.*;

public class CycleInUndirectedGraph {

    // Function to check if there's a cycle in the graph
    public static boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V]; // Keep track of visited nodes

        // Iterate over all vertices (for disconnected components)
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // Call DFS to detect cycle starting from node i
                if (isCyclicDFS(i, -1, visited, adj)) {
                    return true; // Cycle found
                }
            }
        }
        return false; // No cycle found
    }

    // DFS to detect cycle
    private static boolean isCyclicDFS(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true; // Mark the current node as visited

        // Traverse all adjacent nodes
        for (int neighbor : adj.get(node)) {
            // If the adjacent node is not visited, call DFS recursively
            if (!visited[neighbor]) {
                if (isCyclicDFS(neighbor, node, visited, adj)) {
                    return true;
                }
            }
            // If the adjacent node is visited and is not the parent, then there's a cycle
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Enter number of vertices (V): ");
        int V = sc.nextInt();

        // Input number of edges
        System.out.print("Enter number of edges (E): ");
        int E = sc.nextInt();

        // Initialize adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Input edges
        System.out.println("Enter the edges:");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(); // Start of edge
            int v = sc.nextInt(); // End of edge
            adj.get(u).add(v); // Add edge to adjacency list
            adj.get(v).add(u); // Since it's undirected, add reverse edge as well
        }

        // Call the function to check for a cycle
        boolean hasCycle = isCyclic(V, adj);

        // Output result
        if (hasCycle) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        sc.close();
    }
}
