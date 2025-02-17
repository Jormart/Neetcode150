import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        // Define the maximum area variable
        int maxArea = 0;
        // Define the stack to store the index of the heights
        Stack<Integer> stack = new Stack<>();
        // Define the length of the heights
        int n = heights.length;
        // Loop through the heights
        for (int i = 0; i <= n; i++) {
            // Define the current height
            int currentHeight = (i == n) ? 0 : heights[i];
            // Check if the stack is empty or the current height is greater than 
            // the height at the top of the stack
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                // Get the height at the top of the stack
                int height = heights[stack.pop()];
                // Get the width of the rectangle
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                // Update the maximum area
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i); // Push the index of the current height to the stack
        }
        // Return the maximum area
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test cases
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights1)); // Output: 10
        int[] heights2 = {2, 4};
        System.out.println(solution.largestRectangleArea(heights2)); // Output: 4
    }
}