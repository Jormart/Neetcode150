// Problem: 518. Coin Change II
class Solution {
    // Approach: Dynamic Programming
    // Time Complexity: O(n * m) where n is the number of coins and m is the amount
    // Space Complexity: O(m) where m is the amount
    // Explanation: We use a 1D array to store the number of ways to make each
    // amount from 0 to m.
    // We iterate through each coin and update the number of ways to make each
    // amount by adding the number of ways to make the amount minus the coin value.
    // We start from the coin value to avoid using the same coin multiple times in
    // the same iteration.
    // The final answer will be in dp[m], which represents the number of ways to
    // make the amount m.
    // Note: The order of coins does not matter, so we can use the same coin
    // multiple times in different iterations.
    public int change(int amount, int[] coins) {
        // dp array to store the number of ways to make each amount
        int[] dp = new int[amount + 1];
        dp[0] = 1; // There is one way to make amount 0, which is to use no coins

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin]; // Update the number of ways to make amount j
            }
        }

        return dp[amount]; // Return the number of ways to make the amount
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int amount = 5;
        int[] coins = { 1, 2, 5 };
        System.out.println(solution.change(amount, coins)); // Output: 4
    }
}
