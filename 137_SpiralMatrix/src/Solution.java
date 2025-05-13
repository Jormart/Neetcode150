import java.util.*;

// 54. Spiral Matrix
// https://leetcode.com/problems/spiral-matrix/
class Solution {
    // Approach
    // 1. Initialize the boundaries of the matrix: top, bottom, left, right.
    // 2. Use a while loop to traverse the matrix in a spiral order.
    // 3. In each iteration, traverse the top row from left to right, then move the
    // top boundary down.
    // 4. Traverse the right column from top to bottom, then move the right boundary
    // left.
    // 5. If there are still rows remaining, traverse the bottom row from right to
    // left, then move the bottom boundary up.
    // 6. If there are still columns remaining, traverse the left column from bottom
    // to top, then move the left boundary right.
    // 7. Continue this process until all elements have been added to the result
    // list.
    // 8. Return the result list.
    // Complexity Analysis
    // Time Complexity: O(m * n), where m is the number of rows and n is the number
    // of columns in the matrix. We visit each element exactly once.
    // Space Complexity: O(1), if we do not consider the space required for the
    // output list. The space used for the result list is O(m * n) in the worst
    // case, but it is not counted in the space complexity analysis as per the
    // problem statement.
    public List<Integer> spiralOrder(int[][] matrix) {
        // Pre-allocate result list to avoid resizing
        List<Integer> result = new ArrayList<>(matrix.length == 0 ? 0 : matrix.length * matrix[0].length);
        if (matrix.length == 0) {
            return result;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                // Traverse from right to left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // Traverse from bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result); // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}