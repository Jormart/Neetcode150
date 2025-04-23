import java.util.*;

// Problem: 778. Swim in Rising Water
// Link: https://leetcode.com/problems/swim-in-rising-water/description/
// Difficulty: Hard
// Tags: Binary Search, Union Find, Graph, Heap, BFS, DFS
class Solution {
    // Solution using DFS and binary search
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = 0, right = n * n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSwim(grid, mid)) {
                right = mid; // Try to swim in shallower water
            } else {
                left = mid + 1; // Need deeper water
            }
        }
        return left; // The minimum time to swim to the bottom right corner
    }

    // Optimized solution using DFS and binary search
    private boolean canSwim(int[][] grid, int t) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        return dfs(grid, visited, 0, 0, t);
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int x, int y, int t) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] > t) {
            return false;
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return true; // Reached the bottom right corner
        }
        visited[x][y] = true; // Mark the cell as visited
        // Explore all four directions
        return dfs(grid, visited, x + 1, y, t) ||
                dfs(grid, visited, x - 1, y, t) ||
                dfs(grid, visited, x, y + 1, t) ||
                dfs(grid, visited, x, y - 1, t);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
                { 0, 2 },
                { 1, 3 }
        };
        System.out.println(solution.swimInWater(grid)); // Output: 3

        int[][] grid2 = {
                { 0, 1, 2, 3, 4 },
                { 24, 23, 22, 21, 5 },
                { 12, 13, 14, 15, 16 },
                { 11, 10, 9, 8, 7 },
                { 20, 19, 18, 17, 6 }
        };
        System.out.println(solution.swimInWater(grid2)); // Output: 16
    }
}