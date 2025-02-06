import java.util.*;

class Solution {
    public boolean isValid(String s) {
        // Create a hashmap to store the mappings of the brackets
        HashMap<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        // Create a stack to store the brackets
        Stack<Character> stack = new Stack<>();
        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the current character is not a closing bracket
            if (!mappings.containsKey(c)) {
                // Push the character onto the stack
                stack.push(c);
            } else {
                // If the stack is empty, return false
                if (stack.empty()){
                    return false;
                }
                char topElement = stack.pop();
                // If the mapping for this bracket doesn't match the stack's top element, return false
                if (topElement != mappings.get(c)) {
                    return false;
                }
            }
        }
        // If the stack is empty, return true
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "()";
        System.out.println(sol.isValid(s)); // Output: true

        s = "()[]{}";
        System.out.println(sol.isValid(s)); // Output: true

        s = "(]";
        System.out.println(sol.isValid(s)); // Output: false

        s = "([)]";
        System.out.println(sol.isValid(s)); // Output: false

        s = "{[]}";
        System.out.println(sol.isValid(s)); // Output: true
    }
}