// 134. Gas Station
// https://leetcode.com/problems/gas-station/description/
class Solution {
    // Greedy approach algorithm
    // Time complexity: O(n)
    // Space complexity: O(1)
    // The algorithm works by iterating through the gas stations and keeping track
    // of the total gas and cost.
    // If at any point the total gas is less than the total cost, we cannot complete
    // the circuit from that startIndexing point.
    // We then reset the startIndexing point to the next station and continue the
    // process.
    // If we reach the end of the array and have enough gas to cover the cost, we
    // return the startIndexing point.
    // If we finish the loop and have not found a valid startIndexing point, we
    // return
    // -1.
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            // If we cannot reach the next station, we need to reset the startIndexing
            // point
            if (tank < 0) {
                startIndex = i + 1;
                tank = 0;
            }
        }

        // If the total gas is less than the total cost, we cannot complete the
        // circuit
        return totalGas < totalCost ? -1 : startIndex;
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 2, 3, 4, 5, 1 };
        int result = solution.canCompleteCircuit(gas, cost);
        System.out.println(result); // Output: 4
    }
}