import java.util.*;

class Solution {
    // BFS approach to solve the problem of rotting oranges
    // Time Complexity: O(N), where N is the number of cells in the grid.
    // Space Complexity: O(N), for the queue used in BFS.
    // The algorithm works as follows:
    // 1. Count the number of fresh oranges and add all rotten oranges to a queue.
    // 2. Perform BFS to rot the fresh oranges by checking all 4 directions (up,
    // down, left, right).
    // 3. For each level of BFS, increase the time taken.
    // 4. If there are still fresh oranges left after BFS, return -1.
    // 5. Otherwise, return the time taken minus 1 (as the last level of BFS is not
    // complete).

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int rows = grid.length, cols = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Count fresh oranges and add rotten oranges to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        if (freshCount == 0) {
            return 0; // No fresh oranges to rot
        }

        int minutes = 0;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];
                    // Check if the neighbor is within bounds and is a fresh orange
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2; // Rot the fresh orange
                        queue.offer(new int[] { x, y });
                        freshCount--; // Decrease the count of fresh oranges
                    }
                }
            }
            minutes++; // Increase the time taken for each level of BFS
        }

        // Subtract 1 because the last level of BFS is not complete
        return freshCount == 0 ? minutes - 1 : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        System.out.println(solution.orangesRotting(grid)); // Output: 4
    }
}