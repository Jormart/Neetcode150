// 10. Regular Expression Matching
// https://leetcode.com/problems/regular-expression-matching/
class Solution {
    // Dynamic Programming Approach
    // Time Complexity: O(m * n), where m is the length of the string and n is the
    // length of the pattern
    // Space Complexity: O(m * n), where m is the length of the string and n is the
    // length of the pattern
    // m = s.length(), n = p.length()
    // dp[i][j] = true if s[0..i-1] matches p[0..j-1]
    // dp[i][j] = false if s[0..i-1] does not match p[0..j-1]
    // dp[0][0] = true, empty string matches empty pattern
    // dp[i][0] = false, non-empty string does not match empty pattern
    // dp[0][j] = true if p[0..j-1] is a valid pattern that matches empty string
    // dp[i][j] = dp[i-1][j-1] if s[i-1] == p[j-1] or p[j-1] == '.'
    // dp[i][j] = dp[i][j-2] if p[j-1] == '*', and s[i-1] does not match p[j-2]
    // dp[i][j] = dp[i-1][j] if p[j-1] == '*', and s[i-1] matches p[j-2]
    // dp[i][j] = dp[i-1][j] || dp[i][j-2] if p[j-1] == '*', and s[i-1] matches
    // p[j-2]

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[s.length() + 1][pLen + 1];
        dp[0][0] = true;

        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (sChar == pChar || pChar == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    dp[i][j] = dp[i][j - 2] || (sChar == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                            && dp[i - 1][j];
                }
            }
        }

        return dp[sLen][pLen];
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        String p = "c*a*b";
        boolean result = solution.isMatch(s, p);
        System.out.println("Is match: " + result); // Output: true
    }

}