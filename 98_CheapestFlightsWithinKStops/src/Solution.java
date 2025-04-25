import java.util.Arrays;

class Solution {
    // Bellman-Ford algorithm to find the cheapest price with at most k stops
    // Time complexity: O(k * E), where E is the number of edges (flights)
    // Space complexity: O(V), where V is the number of vertices (cities)
    // The algorithm works by relaxing the edges k times, where k is the maximum number of stops allowed.
    // In each iteration, it updates the cost to reach each destination node from the source node.
    // If the cost to reach a destination node is updated, it means that a cheaper path has been found.
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costs = new int[n]; // Array to store the minimum cost to reach each node
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;

        // Relax the edges k times
        for (int i = 0; i <= k; i++) {
            int[] tempCosts = costs.clone(); // Clone the costs array for this iteration
            for (int[] flight : flights) {
                int u = flight[0]; // Source node
                int v = flight[1]; // Destination node
                int price = flight[2]; // Price of the flight

                // If the source node has been reached and the cost to reach the destination 
                // node is less than the current cost
                if (costs[u] == Integer.MAX_VALUE) continue; // Skip if the source node is unreachable
                // Update the cost to reach the destination node if the new cost is less
                if (costs[u] + price < tempCosts[v]) {
                    tempCosts[v] = costs[u] + price; 
                }
            }
            costs = tempCosts; // Update the costs array for the next iteration

        }   
        // If the destination node has not been reached, return -1
        // Otherwise, return the minimum cost to reach the destination node
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int n = 3;
        int src = 0;
        int dst = 2;
        int k = 1;
        System.out.println(solution.findCheapestPrice(n, flights, src, dst, k)); // Output: 500
    }
}