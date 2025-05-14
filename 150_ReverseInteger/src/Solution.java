// 7. Reverse Integer
// https://leetcode.com/problems/reverse-integer/description/
class Solution {
    // Optimal Approach using bits manipulation
    // Time Complexity: O(log10(n)), where n is the input number
    // Space Complexity: O(1)
    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10; // Get the last digit
            x /= 10; // Remove the last digit from x

            // Check for overflow and underflow
            if (reversed > Integer.MAX_VALUE / 10 ||
                    (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Overflow
            }
            if (reversed < Integer.MIN_VALUE / 10 ||
                    (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Underflow
            }

            reversed = reversed * 10 + digit; // Append the digit to the reversed integer
        }
        return reversed;
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 123;
        int reversed = solution.reverse(x);
        System.out.println("Reversed integer: " + reversed); // Output: 321
    }
}