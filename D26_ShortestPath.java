import java.util.*;

public class ShortestPathInGraph {
    
    // Function to find the shortest path using BFS
    public static int bfsShortestPath(List<List<Integer>> adjList, int start, int end) {
        // Edge case where start and end are the same
        if (start == end) {
            return 0;
        }

        // Initialize visited array to keep track of visited nodes
        boolean[] visited = new boolean[adjList.size()];
        
        // Initialize a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        // Add the start node to the queue and mark it as visited
        queue.add(start);
        visited[start] = true;
        
        // Level count to track the number of edges (distance)
        int level = 0;
        
        // BFS loop
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++; // Increment level at the start of each BFS layer
            
            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                // Traverse all adjacent nodes
                for (int neighbor : adjList.get(current)) {
                    // If we find the destination node, return the level
                    if (neighbor == end) {
                        return level;
                    }
                    
                    // If the node has not been visited, add it to the queue
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }
        
        // If no path is found, return -1
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input: number of vertices
        System.out.println("Enter number of vertices:");
        int V = sc.nextInt();
        
        // Initialize the adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Input: number of edges
        System.out.println("Enter number of edges:");
        int E = sc.nextInt();
        
        // Input: edges
        System.out.println("Enter the edges (pair of vertices for each edge):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u); // Since the graph is undirected
        }
        
        // Input: start and end nodes
        System.out.println("Enter start and end vertices:");
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        // Call the BFS function to find the shortest path
        int result = bfsShortestPath(adjList, start, end);
        
        // Output result
        if (result != -1) {
            System.out.println("Shortest path length: " + result);
        } else {
            System.out.println("No path exists between " + start + " and " + end);
        }
        
        sc.close();
    }
}
