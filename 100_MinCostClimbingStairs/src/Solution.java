class Solution {
    // Dinamic programming approach with 2 pointers to save space
    public int minCostClimbingStairs(int[] cost) {
        // Edge cases for 0, 1, and 2 elements
        if (cost.length == 1)
            return cost[0];
        if (cost.length == 2)
            return Math.min(cost[0], cost[1]);

        // Initialize the first two steps continuously
        int first = cost[0];
        int second = cost[1];

        // Iterate through the cost array starting from the third element
        for (int i = 2; i < cost.length; i++) {
            // Calculate the minimum cost to reach the current step
            int current = cost[i] + Math.min(first, second);
            // Update the first and second steps for the next iteration
            first = second;
            second = current;
        }
        // Return the minimum cost to reach the top of the stairs
        return Math.min(first, second);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] cost = { 10, 15, 20 };
        System.out.println(solution.minCostClimbingStairs(cost)); // Output: 15
    }
}