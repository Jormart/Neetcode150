class Solution {
    // Dinamic programming approach to count palindromic substrings
    // Time complexity: O(n^2)
    // Space complexity: O(1)
    // This solution uses a two-pointer technique to count palindromic substrings
    // by expanding around each character and between each pair of characters.
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // Count odd length palindromes
            count += countPalindromes(s, i, i);
            // Count even length palindromes
            count += countPalindromes(s, i, i + 1);
        }
        return count;
    }

    // Helper function to count palindromes centered at (left, right)
    private int countPalindromes(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    // Test the function with some test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("abc")); // Output: 3
        System.out.println(solution.countSubstrings("aaa")); // Output: 6
        System.out.println(solution.countSubstrings("ababa")); // Output: 9
    }
}
