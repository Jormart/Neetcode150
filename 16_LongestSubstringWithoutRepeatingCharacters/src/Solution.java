import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Check the edge cases if the string is empty or null
        if (s == null || s.length() == 0) {
            return 0;
        }
        // Initialize the left and right pointers and the answer
        int left = 0, right = 0, answer = 0;
        // Create a hashset to store the characters
        Set<Character> set = new HashSet<>();
        // Iterate through the string
        while (right < s.length()) {
            // If the character is not present in the hashset
            if (!set.contains(s.charAt(right))) {
                // Add the character to the hashset
                set.add(s.charAt(right));
                // Increment the right pointer
                right++;
                // Update the answer
                answer = Math.max(answer, right - left);
            } else {
                // If the character is present in the hashset
                // Remove the character from the hashset
                set.remove(s.charAt(left));
                // Increment the left pointer
                left++;
            }
        }
        // Return the answer
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Test case 1
        String s1 = "abcabcbb";
        // Output: 3
        System.out.println(sol.lengthOfLongestSubstring(s1));
        // Test case 2
        String s2 = "bbbbb";
        // Output: 1
        System.out.println(sol.lengthOfLongestSubstring(s2));
        // Test case 3
        String s3 = "pwwkew";
        // Output: 3
        System.out.println(sol.lengthOfLongestSubstring(s3));
    }
}