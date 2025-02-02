import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        // Check if the input strings are empty or null
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        // Create a hashmap to store the frequency of characters in the target string
        Map<Character, Integer> targetMap = new HashMap<>();
        // Populate the targetMap with the frequency of characters in the target string
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        // Number of uniquer characters in the target string
        int required = targetMap.size();
        // Initialize the left and right pointers
        int left = 0, right = 0;
        // Initialize the number of unique characters found in the window
        int create = 0;
        // Initialize the hashmap to store the frequency of characters in the window
        int[] ans = { -1, 0, 0 };
        // Create a hasmap to keep track of the frequency of characters in the window
        Map<Character, Integer> windowMap = new HashMap<>();

        // Iterate through the string
        while (right < s.length()) {
            // Get the character at the right pointer
            char c = s.charAt(right);
            // Add the character to the windowMap
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            // Check if the character is in the target string and the frequency of the
            // character in the window is the same as the target string
            if (targetMap.containsKey(c) && targetMap.get(c).intValue() == windowMap.get(c).intValue()) {
                create++;
            }
            // Check if the window contains all the characters in the target string
            while (left <= right && create == required) {
                // Get the character at the left pointer
                c = s.charAt(left);
                // Get the length of the current window
                int windowLength = right - left + 1;
                // Check if the current window is smaller than the previous window
                if (ans[0] == -1 || windowLength < ans[0]) {
                    ans[0] = windowLength;
                    ans[1] = left;
                    ans[2] = right;
                }
                // Remove the character at the left pointer from the windowMap
                windowMap.put(c, windowMap.get(c) - 1);
                // Check if the character is in the target string and the frequency of the
                // character in the window is less than the target string
                if (targetMap.containsKey(c) && windowMap.get(c).intValue() < targetMap.get(c).intValue()) {
                    create--;
                }
                // Move the left pointer to the right
                left++;
            }
            // Move the right pointer to the right
            right++;
        }

        // Check if a valid window was found
        if (ans[0] == -1) {
            return "";
        }
        // Return the substring of the valid window
        return s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test cases to validate the solution
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
        System.out.println(solution.minWindow("a", "a")); // Output: "a"
        System.out.println(solution.minWindow("a", "aa")); // Output: ""
    }
}