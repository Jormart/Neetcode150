// 678. Valid Parenthesis String
// https://leetcode.com/problems/valid-parenthesis-string/
class Solution {
    // Approach: Greedy Algorithm with Two Pointers
    // We can use a greedy approach to check if the string is valid.
    // We can keep track of the low and high bounds to handle the flexibility of
    // '*'.
    // For each character in the string:
    // - If it's '(', we increment both low and high bounds.
    // - If it's ')', we decrement both low and high bounds.
    // - If it's '*', we decrement low and increment high bounds.
    // At any point, if high becomes negative, we return false.
    // If low becomes negative, we reset it to 0.
    // At the end, we check if low is 0 to determine if the string is valid.
    // Time Complexity: O(n), where n is the length of the string.
    // Space Complexity: O(1), we are using only a constant amount of space.
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // '*'
                low--;
                high++;
            }
            if (high < 0)
                return false;
            if (low < 0)
                low = 0;
        }
        return low == 0;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkValidString("()")); // true
        System.out.println(solution.checkValidString("(*)")); // true
        System.out.println(solution.checkValidString("(*))")); // true
        System.out.println(solution.checkValidString(")(")); // false
        System.out.println(solution.checkValidString("((*)")); // true
    }
}