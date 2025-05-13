// 48. Rotate Image
// https://leetcode.com/problems/rotate-image/
class Solution {
    // Approach: In-place rotation
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    // Algorithm:
    // 1. Transpose the matrix
    // 2. Reverse each row
    // 3. Return the rotated matrix
    // 4. The matrix is rotated in place, so no need to return anything
    // 5. The input matrix is modified in place
    // 6. The matrix is rotated in place, so no need to return anything
    // 7. The input matrix is modified in place
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    // Test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        solution.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}