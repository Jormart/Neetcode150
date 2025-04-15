import java.util.*;

class Solution {
    // This method finds all possible palindrome partitioning of a given string s.
    // It returns a list of lists, where each inner list contains the substrings
    // that are palindromes.
    // The method uses backtracking to explore all possible partitions.
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    // This method checks if a given string is a palindrome.
    // A palindrome reads the same backward as forward.
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // This method uses backtracking to find all possible partitions of the string
    // s.
    // It explores all possible substrings starting from the index 'start' and
    // checks if they are palindromes.
    private void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (isPalindrome(substring)) {
                path.add(substring);
                backtrack(s, end, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        List<List<String>> result = solution.partition(s);
        System.out.println(result); // Output: [["a","a","b"],["aa","b"]]
    }
}