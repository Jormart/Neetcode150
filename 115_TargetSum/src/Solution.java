// LeetCode 494. Target Sum
// https://leetcode.com/problems/target-sum/description/
class Solution {
    // Dynamic Programming approach
    // Time Complexity: O(n * target)
    // Space Complexity: O(target)
    // where n is the length of nums and target is the absolute value of target
    // This approach uses a 1D array to store the number of ways to achieve each sum
    // from 0 to target. The array is updated in reverse order to avoid overwriting
    // the values that are needed for the current iteration.
    // The final result is the value at index target in the array.

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // Check if the target is achievable
        if (target > sum || (sum + target) % 2 != 0) {
            return 0;
        }
        int S1 = (sum + target) / 2;
        // Early check to prevent negative index
        if (S1 < 0) {
            return 0;
        }
        int[] dp = new int[S1 + 1];
        dp[0] = 1; // Base case: one way to achieve sum of 0
        for (int num : nums) {
            // Reverse order to avoid counting the same number multiple times
            for (int j = S1; j >= num; j--) {
                dp[j] += dp[j - num]; // Update the number of ways to achieve sum j
            }
        }
        return dp[S1];
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;
        int result = solution.findTargetSumWays(nums, target);
        System.out.println("Number of ways to achieve target sum: " + result); // Output: 5
    }
}