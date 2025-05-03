// LeetCode 115. Distinct Subsequences
// https://leetcode.com/problems/distinct-subsequences/description/
class Solution {
    // Dynamic Programming approach to count distinct subsequences
    // Time Complexity: O(m * n), where m is the length of s and n is the length of
    // t. Space Complexity: O(n), where n is the length of t
    // Optimize solution with a space complexity to O(n) by using a single array
    // instead of a 2D array.

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n)
            return 0; // If s is shorter than t, return 0

        // Create a DP array to store the number of distinct subsequences
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: empty string t can be formed from any prefix of s

        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1]; // Update dp[j] if characters match
                }
            }
        }

        return dp[n]; // Return the number of distinct subsequences of t in s
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "rabbbit";
        String t = "rabbit";
        int result = solution.numDistinct(s, t);
        System.out.println("Number of distinct subsequences: " + result); // Output: 3
    }
}