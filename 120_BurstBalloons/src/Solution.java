// 312. Burst Balloons
// https://leetcode.com/problems/burst-balloons/description/

class Solution {
    // Dynamic Programming approach
    // Time Complexity: O(n^3)
    // Space Complexity: O(n^2)
    // where n is the number of balloons
    // The idea is to use a 2D dp array where dp[i][j] represents the maximum coins
    // that can be obtained by bursting all the balloons between index i and j
    // We can burst the last balloon in the range [i, j] and calculate the coins
    // obtained by bursting the last balloon in the range [i, j]
    // The coins obtained by bursting the last balloon in the range [i, j] is
    // balloons[i - 1] * balloons[k] * balloons[j + 1]
    // where k is the index of the last balloon to be burst in the range [i, j]
    // We can iterate through all the balloons in the range [i, j] and calculate
    // the maximum coins obtained by bursting the last balloon in the range [i, j]
    // The final answer will be stored in dp[1][n] where n is the number of balloons
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Add 1 to the beginning and end of the array
        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }

        // Create a dp array to store the maximum coins
        int[][] dp = new int[n + 2][n + 2];

        // Fill the dp array
        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int i = left; i <= right; i++) {
                    dp[left][right] = Math.max(dp[left][right], dp[left][i - 1] + dp[i + 1][right]
                            + balloons[left - 1] * balloons[i] * balloons[right + 1]);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 3, 1, 5, 8 };
        System.out.println(solution.maxCoins(nums)); // Output: 167
    }
}