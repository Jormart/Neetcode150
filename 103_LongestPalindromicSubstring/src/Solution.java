// 5. Longest Palindromic Substring
// https://leetcode.com/problems/longest-palindromic-substring/
class Solution {
    // Dynamic Programming using 2 pointers to check for palindromes
    // The function checks for palindromes by expanding around the center
    // and keeps track of the longest palindrome found so far.
    // Time complexity: O(n^2), where n is the length of the string
    // Space complexity: O(1)
    public String longestPalindrome(String s) {
        // Edge cases
        if (s == null || s.length() < 1)
            return "";
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = checkPalindrome(s, i, i); // Odd length palindrome
            int len2 = checkPalindrome(s, i, i + 1); // Even length palindrome
            int len = Math.max(len1, len2);
            if (len > right - left) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return s.substring(left, right + 1); // Return the longest palindromic substring
    }

    // Helper function to check for palindromes
    private int checkPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of the palindrome
    }

    // Test case
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "xabcbay";
        System.out.println("L.P.S: " + solution.longestPalindrome(s)); // Output: "abcba"
    }
}