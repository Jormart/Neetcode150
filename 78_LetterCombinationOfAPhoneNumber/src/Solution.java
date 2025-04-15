import java.util.*;

class Solution {
    // Mapping of digits to letters
    private static final String[] MAPPING = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>(); // List to store the combinations
        if (digits == null || digits.length() == 0) {
            return result; // Return empty list if input is empty
        }
        backtrack(digits, 0, new StringBuilder(), result); // Start backtracking
        return result; // Return the final list of combinations
    }

    // Backtracking function to generate combinations
    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // If the current combination is complete, add it to the result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        String letters = MAPPING[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter); // Add the letter to the current combination
            backtrack(digits, index + 1, current, result); // Move to the next digit
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits = "23";
        List<String> combinations = solution.letterCombinations(digits);
        System.out.println(combinations); // Output: [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}