import java.util.Arrays;

class Solution {
    // Dynamic Programming approach to find the number of unique paths in a grid
    // Time Complexity: O(m*n)
    // Space Complexity: O(m*n)
    // where m is the number of rows and n is the number of columns in the grid
    // The function returns the number of unique paths from the top-left corner to
    // the bottom-right corner of a grid of size m x n
    // The function uses a 2D array to store the number of unique paths to each cell

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // Initialize the first row and first column of the dp array to 1
        // because there is only one way to reach any cell in the first row or first
        for (int[] row : dp) {
            Arrays.fill(row, 1);
        }
        // Fill the dp array using the recurrence relation
        // dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // The number of unique paths to the bottom-right corner is stored in
        // dp[m-1][n-1]
        return dp[m - 1][n - 1];
    }

    // Main method to test the uniquePaths function
    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 3; // Number of rows
        int n = 7; // Number of columns
        int result = solution.uniquePaths(m, n);
        // Output the result to the console
        // The expected output for a 3x7 grid is 28 unique paths
        System.out.println("Number of unique paths from top-left to bottom-right: " + result);
    }
}