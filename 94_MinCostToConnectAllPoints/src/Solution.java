class Solution {
    // Prim's algorithm to find the minimum spanning tree (MST) of a graph
    // represented by points in a 2D plane.
    // The function calculates the minimum cost to connect all points.
    // Time complexity: O(N^2), where N is the number of points.
    // Space complexity: O(N), for the visited array.
    // The function uses a priority queue to efficiently find the minimum edge
    // connecting the MST to the remaining points.
    // The function iterates through all points, adding the minimum edge to the MST
    // and marking the point as visited. It continues until all points are included
    // in the MST.
    // The function returns the total cost of the MST.

    public int minCostConnectPoints(int[][] points) {
        // Get the number of points in the input
        int n = points.length;

        // Track which points have been added to our MST
        boolean[] visited = new boolean[n];

        // Keep track of the total cost of all edges in the MST
        int totalCost = 0;

        // Count how many points we've connected so far
        int edgesUsed = 0;

        // For each point, track the minimum cost to connect it to our growing MST
        // This array represents the cost of the cheapest edge from MST to each
        // unvisited point
        int[] minEdge = new int[n];

        // Initialize all points except the starting point with "infinity"
        for (int i = 1; i < n; i++) {
            minEdge[i] = Integer.MAX_VALUE;
        }

        // We start building our MST from the first point (index 0)
        minEdge[0] = 0; // Start from the first point

        // Prim's algorithm main loop - continue until all points are in the MST
        // We need n-1 edges to connect n points, but we use edgesUsed < n as our
        // condition because we increment edgesUsed before adding each edge
        while (edgesUsed < n) {
            // Find the unvisited point with the minimum edge cost to our current MST
            int minCost = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && minEdge[i] < minCost) {
                    minCost = minEdge[i];
                    minIndex = i;
                }
            }

            // Add the cost of connecting this point to our total
            totalCost += minCost;

            // Mark this point as now part of our MST
            visited[minIndex] = true;

            // Increment our counter of connected points
            edgesUsed++;

            // Update the minimum edge costs for all remaining unvisited points
            // This is where we consider if adding the newly visited point gives us
            // a cheaper way to connect any remaining points
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    // Calculate Manhattan distance between points
                    // Manhattan distance = |x1 - x2| + |y1 - y2|
                    int cost = Math.abs(points[minIndex][0] - points[j][0]) +
                            Math.abs(points[minIndex][1] - points[j][1]);

                    // Update minEdge[j] if we found a cheaper way to connect point j to our MST
                    minEdge[j] = Math.min(minEdge[j], cost);
                }
            }
        }

        // Return the total cost of the minimum spanning tree
        return totalCost;
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
        int result = solution.minCostConnectPoints(points);
        System.out.println("Minimum cost to connect all points: " + result);
    }
}