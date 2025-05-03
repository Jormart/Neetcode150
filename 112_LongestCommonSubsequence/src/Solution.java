class Solution {
    // Dynamic Programming approach to find the length of the longest common
    // subsequence
    // between two strings text1 and text2.
    // The function returns the length of the longest common subsequence.
    // Time complexity: O(m * n), where m and n are the lengths of text1 and text2
    // respectively.
    // Space complexity: O(m * n) for the DP table.
    // We can optimize the space complexity to O(min(m, n)) by using a 1D array.
    // However, for simplicity, we will use a 2D array in this implementation.
    // The DP table dp[i][j] will store the length of the longest common subsequence
    // of text1[0..i-1] and text2[0..j-1].
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the longest common subsequence is in dp[m][n]
        return dp[m][n];
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        String text1 = "abcde";
        String text2 = "ace";
        int result = solution.longestCommonSubsequence(text1, text2);
        System.out.println("Length of Longest Common Subsequence: " + result); // Output: 3
    }
}