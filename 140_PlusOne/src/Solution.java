// 66. Plus One
// https://leetcode.com/problems/plus-one/
class Solution {
    // Approach
    // 1. Start from the last digit and add one to it.
    // 2. If the result is less than 10, return the array.
    // 3. If the result is 10, set the current digit to 0 and carry over 1 to the
    // next digit.
    // 4. Repeat the process until all digits are processed or there is no carry
    // over.
    // 5. If there is still a carry over after processing all digits, create a new
    // array with an extra digit and set the first digit to 1.
    // 6. Copy the remaining digits from the original array to the new array.
    // 7. Return the new array.
    // Time Complexity: O(n), where n is the number of digits in the array.
    // Space Complexity: O(1), since we are modifying the input array in place.
    public int[] plusOne(int[] digits) {
        // Start from the last digit and add one to it.
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            // If the result is less than 10, return the array.
            if (digits[i] < 10) {
                return digits;
            }
            // If the result is 10, set the current digit to 0 and carry over 1 to the
            // next digit.
            digits[i] = 0;
        }
        // If there is still a carry over after processing all digits, create a new
        // array with an extra digit and set the first digit to 1.
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        // Copy the remaining digits from the original array to the new array.
        return newDigits;
    }

    // Test case
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] digits = { 1, 2, 3 };
        int[] result = solution.plusOne(digits);
        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }
}