// 72. Edit Distance
// https://leetcode.com/problems/edit-distance/description/

class Solution {
    // Dynamic Programming approach with space optimization
    // Time Complexity: O(m * n), where m and n are the lengths of word1 and word2
    // respectively.
    // Space Complexity: O(n), where n is the length of word2. We only need to keep
    // track of the previous row.
    // This is an optimized version of the DP approach that uses only a single array
    // to store the distances.
    // The idea is to use a 1D array instead of a 2D array to save space. We can
    // update the array in place as we iterate through the characters of the
    // strings.
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // If one of the strings is empty, return the length of the other string
        if (m == 0)
            return n;
        if (n == 0)
            return m;

        // Create a DP array to store the distances
        int[] dp = new int[n + 1];

        // Initialize the first row of the DP table
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            int prev = dp[0]; // Store the value of dp[i-1][j-1]
            dp[0] = i; // Update dp[0] for the current row

            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // Store the value of dp[i][j-1]
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prev; // No operation needed
                } else {
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), prev) + 1; // Insert, Delete, Replace
                }
                prev = temp; // Update prev for the next iteration
            }
        }

        return dp[n]; // The last element contains the minimum edit distance
    }

    // Example usage:
    public static void main(String[] args) {
        Solution solution = new Solution();
        String word1 = "horse";
        String word2 = "ros";
        int result = solution.minDistance(word1, word2);
        System.out.println("Minimum edit distance: " + result); // Output: 3
    }
}