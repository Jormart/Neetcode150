// LeetCode 97. Interleaving String
// https://leetcode.com/problems/interleaving-string/description/
class Solution {
    // Dynamic Programming approach
    // Time Complexity: O(m * n), where m and n are the lengths of s1 and s2
    // respectively.
    // Space Complexity: O(m * n) for the dp array.

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();
        // Edge case: if the lengths of s1 and s2 do not add up to the length of s3,
        // return false.
        if (m + n != l)
            return false; // Length check

        // Create a 2D dp array to store the results of subproblems
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // Base case

        // Fill the first row of the dp array
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Fill the first column of the dp array
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Fill the rest of the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Check if the current character of s3 matches with the current character of s1
                // or s2
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[m][n]; // Final answer
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        boolean result = solution.isInterleave(s1, s2, s3);
        System.out.println("Is Interleaving: " + result); // Output: true
    }
}