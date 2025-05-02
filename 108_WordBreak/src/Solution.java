import java.util.*;

class Solution {
    // Dinamic Programming solution to the word break problem
    // Time complexity: O(n^2)
    // Space complexity: O(n)
    // where n is the length of the string s
    // The idea is to use a boolean array dp where dp[i] is true if the substring
    // s[0..i] can be segmented into words from the dictionary
    // We iterate through the string and for each position i, we check all previous
    // positions j. If dp[j] is true and the substring s[j..i] is in the dictionary,
    // then we can set dp[i] to true. Finally, we return dp[n] where n is the length
    // of s.

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // empty string can be segmented

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean result = solution.wordBreak(s, wordDict);
        System.out.println(result); // Output: true
    }
}