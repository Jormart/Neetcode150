// 91. Decode Ways
// https://leetcode.com/problems/decode-ways/
// Given a string s consisting of digits, return the number of ways to decode it.
class Solution {
    // Solution using dynamic programming to count the number of ways to decode the
    // string.
    // We use two variables (prev1, prev2) to optimize space to O(1) instead of
    // using
    // a dp array.
    // Time complexity: O(n), where n is the length of the string.
    // Space complexity: O(1).

    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;

        int prev2 = 1; // dp[0]: ways to decode empty string
        int prev1 = 1; // dp[1]: ways to decode first char (if not '0')

        for (int i = 2; i <= s.length(); i++) {
            int curr = 0;
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1) {
                curr += prev1;
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                curr += prev2;
            }
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1; // return the last computed value which is the answer
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("226")); // Output: 3
        System.out.println(solution.numDecodings("12")); // Output: 2
        System.out.println(solution.numDecodings("0")); // Output: 0
        System.out.println(solution.numDecodings("06")); // Output: 0
    }
}