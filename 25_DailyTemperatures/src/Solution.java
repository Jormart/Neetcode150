import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Initialize the length of the temperatures array
        int n = temperatures.length;
        // Initialize the result array
        int[] result = new int[n];
        // Initialize the stack
        Stack<Integer> stack = new Stack<>();

        // Iterate through the temperatures array
        for (int i = 0; i < n; i++) {
            // Iterate through the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // Get the index of the top element in the stack
                int index = stack.pop();
                // Calculate the difference between the current index and the index of the top element in the stack
                result[index] = i - index;
            }
            // Push the current index to the stack
            stack.push(i);
        }

        // Return the result array
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        // Output: [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures1)));

        // Test 2
        int[] temperatures2 = {30, 40, 50, 60};
        // Output: [1, 1, 1, 0]
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures2)));
    }
}