import java.util.*;

// Problem: Climbing Stairs
// Link: https://leetcode.com/problems/climbing-stairs/description/
// Difficulty: Easy
// Tags: Dynamic Programming, Fibonacci
class Solution {
    public int climbStairs(int n) {
        // Base cases
        if (n == 0)
            return 1; // One way to climb zero steps (do nothing)
        if (n == 1)
            return 1; // One way to climb one step (one single step)

        // Initialize the two variables to represent the number of ways to climb the
        // last two steps
        int first = 1; // Ways to climb to step 0
        int second = 1; // Ways to climb to step 1

        // Iterate from step 2 to n
        for (int i = 2; i <= n; i++) {
            // Calculate the number of ways to reach the current step
            int current = first + second;
            // Update the previous two steps for the next iteration
            first = second;
            second = current;
        }
        // The last computed value is the number of ways to climb n steps
        return second;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(5)); // Example usage
    }
}