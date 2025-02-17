class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Let's define the dimensions of the matrix
        int m = matrix.length;
        int n = matrix[0].length;

        // Let's define the pointers
        int left = 0;
        int right = m * n - 1;

        // Let's perform the binary search on the matrix
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid / n][mid % n];

            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false; // Target not found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;

        // Output: true
        System.out.println(solution.searchMatrix(matrix, target));
    }
}