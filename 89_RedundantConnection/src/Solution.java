class Solution {
    // This method finds the redundant connection in a graph represented by edges
    // using the Union-Find algorithm. It detects cycles in the graph and returns
    // Disjoint Set Union (DSU) to find the redundant edge.
    public int[] findRedundantConnection(int[][] edges) {
        // Intialize the parent array where parent[i] = i represents the parent of node
        // i
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; // Each node is its own parent initially
        }

        // Iterate through each edge in the graph to find the redundant connection
        for (int[] edge : edges) {
            int u = edge[0]; // First node of the edge
            int v = edge[1]; // Second node of the edge

            // Find the root parent of both nodes
            int rootU = find(parent, u);
            int rootV = find(parent, v);

            // If both nodes have the same root parent, it means adding this edge creates a
            // cycle
            if (rootU == rootV) {
                return edge; // Return the current edge as it is redundant
            } else {
                // Otherwise, union the two nodes by setting one parent to the other
                parent[rootU] = rootV;
            }
        }
        return new int[0]; // If no redundant connection is found (no cycle), return an empty array
    }

    // Helper function to find the root parent of a node using path compression
    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]); // Path compression
        }
        return parent[node]; // Return the root parent of the node
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        int[] result = solution.findRedundantConnection(edges);
        System.out.println("Redundant connection: " + result[0] + ", " + result[1]);
    }

}