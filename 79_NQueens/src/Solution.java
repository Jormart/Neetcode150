import java.util.*;

class Solution {
    // This is a backtracking solution to the N-Queens problem.
    // The idea is to place queens one by one in different columns, starting from
    // the leftmost column.

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(result, board, 0);
        return result;
    }

    // When placing a queen in a column, we check for the following conditions:
    // 1. No two queens can be placed in the same row.
    // 2. No two queens can be placed in the same column.
    private void backtrack(List<List<String>> result, char[][] board, int row) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(result, board, row + 1);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    // 3. No two queens can be placed in the same diagonal.
    // We check the diagonals by ensuring that the difference between the row and
    // column indices is unique.
    // The left diagonal can be checked by ensuring that the difference (row - col)
    // is unique.
    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false; // check column
            if (col - (row - i) >= 0 && board[i][col - (row - i)] == 'Q')
                return false; // check left diagonal
            if (col + (row - i) < board.length && board[i][col + (row - i)] == 'Q')
                return false; // check right diagonal
        }
        return true;
    }

    // This function constructs the board representation from the 2D char array.
    // It converts each row of the board into a string and adds it to the result
    // list.
    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> result = solution.solveNQueens(4);
        for (List<String> board : result) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}