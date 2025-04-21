
// LeetCode 323. Number of Connected Components in an Undirected Graph
// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
// Given n nodes and a list of undirected edges, return the number of connected components in the graph.
// A connected component is a set of nodes such that there is a path between any two nodes in the set.  
// The nodes are numbered from 0 to n - 1, and the edges are represented as pairs of nodes.
// The graph is undirected, meaning that if there is an edge between nodes a and b, there is also an edge between b and a.
import java.util.*;

class Solution {
    // DFS approach to count connected components in an undirected graph
    // Time Complexity: O(V + E), where V is the number of vertices and E is the
    // number of edges
    // Space Complexity: O(V), for the visited array and the adjacency list
    public int countComponents(int n, int[][] edges) {
        // Create an adjacency list to represent the graph
        int[] visited = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(graph, visited, i);
            }
        }
        return count;
    }

    // DFS helper method
    private void dfs(List<List<Integer>> graph, int[] visited, int node) {
        visited[node] = 1;
        for (int neighbor : graph.get(node)) {
            if (visited[neighbor] == 0) {
                dfs(graph, visited, neighbor); // Recursively visit all connected nodes
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        System.out.println(solution.countComponents(n, edges)); // Output: 2
    }

}