class Solution {
    // This is a solution to the LeetCode problem "Surrounded Regions".
    // The problem is to capture all regions surrounded by 'X' on a board
    // represented by a 2D character array.
    // The solution uses a depth-first search (DFS) approach to find and capture
    // the surrounded regions.
    // The algorithm works as follows:
    // 1. Iterate through the board and find all 'O's on the border.
    // 2. For each 'O' found, perform a DFS to mark all connected 'O's as 'E'
    // (escaped).
    // 3. After marking all escaped 'O's, iterate through the board again.
    // 4. Change all remaining 'O's to 'X' (captured) and all 'E's back to 'O'
    // (escaped).
    // 5. Return the modified board.
    // The time complexity of this algorithm is O(m * n), where m is the number of
    // rows and n is the number of columns in the board.
    // The space complexity is O(m * n) in the worst case due to the recursion
    // stack.
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;

        // Mark all 'O's on the border and their connected 'O's as 'E'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        // Change all remaining 'O's to 'X' and all 'E's back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    // Helper method to perform DFS and mark connected 'O's as 'E'
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'E'; // Mark as escaped
        dfs(board, i - 1, j); // Up
        dfs(board, i + 1, j); // Down
        dfs(board, i, j - 1); // Left
        dfs(board, i, j + 1); // Right
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' }
        };
        solution.solve(board);
        for (char[] row : board) {
            System.out.println(row);
        }
    }
}
