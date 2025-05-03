
// 322. Coin Change
// https://leetcode.com/problems/coin-change/description/
import java.util.Arrays;

import java.util.Arrays;

class Solution {
    // Optimal approach using Dynamic Programming and memoization
    // Time Complexity: O(n * m) where n is the amount and m is the number of coins
    // Space Complexity: O(n) for the dp array
    // where n is the amount and m is the number of coins
    // The idea is to use a dp array where dp[i] represents the minimum number of
    // coins needed to make amount i.
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // Initialize the dp array with a value greater than amount
        Arrays.fill(dp, amount + 1);
<<<<<<< HEAD
=======
        
>>>>>>> 3aaa280244c2860d85829bde8abab2a2246327cf
        dp[0] = 0; // Base case: 0 coins are needed to make amount 0

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(solution.coinChange(coins, amount)); // Output: 3 (11 = 5 + 5 + 1)

    }
}