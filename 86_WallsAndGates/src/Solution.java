
// Problem: 286. Walls and Gates
// URL: https://leetcode.com/problems/walls-and-gates/
// You're given a 2D grid of integers, where each cell can be one of the following:
// -1 representing a wall or an obstacle.
// 0 representing a gate.
// INF representing an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as a distance to a gate.
// You want to fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
// Example 1:
// Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,-1,-1],[0,-1,2147483647,2147483647]]
// Output: [[3,-1,0,1],[2,1,2,-1],[1,-1,-1,-1],[0,-1,1,2]]
import java.util.*;

class Solution {
    // Approach: BFS
    // 1. Initialize a queue and add all gates (0s) to the queue.
    // 2. Perform BFS from all gates simultaneously, updating the distance of each
    // empty room (INF) to the nearest gate.
    // 3. Continue until all reachable rooms are filled with the correct distance or
    // the queue is empty.
    // 4. Return the modified grid.
    // Time Complexity: O(m * n), where m is the number of rows and n is the number
    // of columns in the grid.
    private static final int INF = Integer.MAX_VALUE;
    private static final int[] directions = { 0, 1, 0, -1, 0 }; // Right, Down, Left, Up

    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Add all gates (0s) to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        // Perform BFS from all gates simultaneously
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int newX = x + directions[d];
                int newY = y + directions[d + 1];

                // Check if the new position is within bounds and is an empty room (INF)
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == INF) {
                    grid[newX][newY] = grid[x][y] + 1; // Update distance to nearest gate
                    queue.offer(new int[] { newX, newY }); // Add to queue for further exploration
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] rooms = {
                { INF, -1, 0, INF },
                { INF, INF, INF, -1 },
                { INF, -1, -1, -1 },
                { 0, -1, INF, INF }
        };
        solution.islandsAndTreasure(rooms);
        for (int[] row : rooms) {
            System.out.println(Arrays.toString(row));
        }
    }
}
