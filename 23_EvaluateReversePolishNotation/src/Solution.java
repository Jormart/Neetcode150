import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        // Initialize a stack to store the numbers
        Stack<Integer> stack = new Stack<>();
        // Iterate through the tokens
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop(); // Pop the second number
                int a = stack.pop(); // Pop the first number
                int result = applyOperator(a, b, token); // Apply the operator
                stack.push(result); // Push the result back to the stack
            } else {
                stack.push(Integer.parseInt(token)); // Push the number to the stack
            }
        }
        return stack.pop(); // Return the result
    }
    // Helper function to check if the token is an operator
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    // Helper function to apply the operator
    private int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] tokens = {"2", "1", "+", "3", "*"};
        // Output: 9
        System.out.println(sol.evalRPN(tokens));
    }
}