import java.util.*;

// LeetCode 261. Graph Valid Tree
// https://leetcode.com/problems/graph-valid-tree/description/
// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
// A valid tree means that there is no cycle and all nodes are connected.
// A tree is a connected graph with no cycles. A valid tree must have exactly n-1 edges, where n is the number of nodes.
class Solution {
    // Approach: DFS to check for cycles and connectivity
    // 1. Check if the number of edges is equal to n - 1.
    // 2. Use DFS to check for cycles and mark visited nodes.
    // 3. After DFS, check if all nodes are visited.
    // 4. If all nodes are visited and no cycles are detected, return true.
    public boolean validTree(int n, int[][] edges) {
        if (n == 0)
            return false;
        if (edges.length != n - 1)
            return false; // A tree must have exactly n-1 edges

        // Create an adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // Add edges to the graph
        // Since the graph is undirected, add both directions
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Array to keep track of visited nodes
        // Start DFS from the first node (0)
        boolean[] visited = new boolean[n];
        if (!dfs(graph, 0, visited, -1))
            return false;

        // Check if all nodes are visited
        for (boolean visit : visited) {
            if (!visit)
                return false;
        }

        return true;
    }

    // DFS function to check for cycles and mark visited nodes
    private boolean dfs(List<List<Integer>> graph, int node, boolean[] visited, int parent) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (!dfs(graph, neighbor, visited, node))
                    return false;
            } else if (neighbor != parent) { // A cycle is detected
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        System.out.println(solution.validTree(n, edges)); // Output: true

        n = 5;
        edges = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 0 } };
        System.out.println(solution.validTree(n, edges)); // Output: false
    }
}
