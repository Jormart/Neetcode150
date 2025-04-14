class Solution {
    private char[][] board; // The board of characters
    private int rows; // Number of rows in the board
    private int cols; // Number of columns in the board

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        // Iterate through each cell in the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start DFS from each cell
                if (dfs(i, j, word, 0)) {
                    return true; // If we find the word, return true
                }
            }
        }
        return false; // If no path is found, return false
    }

    // Depth-First Search (DFS) function to explore the board
    private boolean dfs(int row, int col, String word, int index) {
        // If we have found the entire word, return true
        if (index == word.length()) {
            return true;
        }

        // Check if the current position is out of bounds or does not match the current
        // character in the word
        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited by replacing it with a special character
        char temp = board[row][col];
        board[row][col] = '#'; // Mark as visited

        // Explore all four possible directions: up, down, left, right
        boolean found = dfs(row + 1, col, word, index + 1) ||
                dfs(row - 1, col, word, index + 1) ||
                dfs(row, col + 1, word, index + 1) ||
                dfs(row, col - 1, word, index + 1);

        // Restore the original character in the cell
        board[row][col] = temp; // Unmark

        return found; // Return whether we found the word in this path
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word = "ABCCED";
        System.out.println(solution.exist(board, word)); // Output: false
    }

}