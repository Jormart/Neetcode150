// LeetCode 329. Longest Increasing Path in a Matrix
// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
class Solution {
    // DFS + Memoization
    // Accepted and recommended by LeetCode
    // Time Complexity: O(m * n)
    // Space Complexity: O(m * n)
    // where m is the number of rows and n is the number of columns in the matrix
    private int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] memo = new int[m][n];
        int maxPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, memo, i, j));
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int[][] memo, int i, int j) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        for (int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                memo[i][j] = Math.max(memo[i][j], dfs(matrix, memo, x, y));
            }
        }
        return ++memo[i][j]; // Include the current cell in the path length
    }

    // Example usage:
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                { 9, 9, 4 },
                { 6, 6, 8 },
                { 2, 1, 1 }
        };
        System.out.println(solution.longestIncreasingPath(matrix)); // Output: 4
    }

}