import java.util.*;

class Solution {
    // Function to find the cells that can reach both the Pacific and Atlantic
    // oceans using DFS approach.
    // The function takes a 2D array of heights as input and returns a list of lists
    // of integers. Each inner list contains the row and column indices of a cell
    // that can reach both oceans.
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        List<List<Integer>> result = new ArrayList<>();

        // Perform DFS for Pacific Ocean
        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, cols - 1);
        }
        // Perform DFS for Atlantic Ocean
        for (int j = 0; j < cols; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, rows - 1, j);
        }

        // Find cells that can reach both oceans
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    // DFS function to explore the cells and mark them as reachable for the given
    // ocean
    private void dfs(int[][] heights, boolean[][] ocean, int row, int col) {
        ocean[row][col] = true;
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (isValid(newRow, newCol, rows, cols) && !ocean[newRow][newCol]
                    && heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, ocean, newRow, newCol);
            }
        }
    }

    // Function to check if the cell is within the bounds of the grid
    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    // Main function to test the pacificAtlantic function
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] heights = {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 2 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 }
        };
        List<List<Integer>> result = solution.pacificAtlantic(heights);
        System.out.println(result); // Expected output: [[0,4],[1,4],[2,2],[3,0],[3,1],[4,0]]
    }
}