import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        // Create a list to store the result
        List<String> result = new ArrayList<>();
        // Create a StringBuilder to store the current string
        StringBuilder current = new StringBuilder();
        // Call the backtrack method to generate the result
        backtrack(result, current, 0, 0, n);
        return result;
    }
    // Helper methond for backtracking
    public void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // If the current string has the maximum number of parentheses
        if (current.length() == max * 2) { 
            result.add(current.toString());
            return;
        }
        // If the number of open parentheses is less than the max number of parentheses
        if (open < max) { 
            // Append an open parenthesis to the current string
            current.append("(");
            // If the number of open parentheses is less than the max number of parentheses
            backtrack(result, current, open + 1, close, max);
            // Remove the last character from the current string
            current.deleteCharAt(current.length() - 1);
        }
        // If the number of close parentheses is less than the number of open parentheses
        if (close < open) { 
            // Append a close parenthesis to the current string
            current.append(")");
            // If the number of close parentheses is less than the number of open parentheses
            backtrack(result, current, open, close + 1, max);
            // Remove the last character from the current string
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        List<String> result = solution.generateParenthesis(n);
        System.out.println("Result: " + result);
    }
}