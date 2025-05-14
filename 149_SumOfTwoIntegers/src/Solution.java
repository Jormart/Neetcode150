// 371. Sum of Two Integers
// https://leetcode.com/problems/sum-of-two-integers/description/
class Solution {
    // This is a bit manipulation problem.
    // The idea is to use bitwise operations to calculate the sum without using the
    // + operator.
    // The sum of two integers can be calculated using the following steps:
    // 1. Calculate the carry using bitwise AND (&) and left shift (<<).
    // 2. Calculate the sum without carry using bitwise XOR (^).
    // 3. Repeat the process until there is no carry left.
    // The carry is calculated by ANDing the two numbers and left shifting the
    // result by 1.
    // The sum without carry is calculated by XORing the two numbers.
    // The process is repeated until there is no carry left.
    // The time complexity of this solution is O(1) because the number of iterations
    // is limited to 32 (the number of bits in an integer).
    // The space complexity is O(1) because we are using a constant amount of space.
    public int getSum(int a, int b) {
        // Iterate until there is no carry
        while (b != 0) {
            // Calculate the carry
            int carry = a & b;
            // Calculate the sum without carry
            a = a ^ b;
            // Calculate the carry for the next iteration
            b = carry << 1;
        }

        return a;
    }

    // Test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSum(1, 2)); // Output: 3
        System.out.println(solution.getSum(-2, 3)); // Output: 1
        System.out.println(solution.getSum(0, 0)); // Output: 0
        System.out.println(solution.getSum(-1, -1)); // Output: -2
    }
}