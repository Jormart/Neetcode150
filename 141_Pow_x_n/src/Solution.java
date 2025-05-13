// 50. Pow(x, n)
// https://leetcode.com/problems/powx-n/description/
class Solution {
    // Approach: Binary Exponentiation
    // Explanation:
    // The idea is to use the property of exponents that allows us to break down the
    // problem into smaller subproblems.
    // If n is even, we can express x^n as (x^(n/2))^2.
    // If n is odd, we can express x^n as x * x^(n-1).
    // This allows us to reduce the exponent by half at each step, leading to a
    // logarithmic time complexity.
    // We also handle the case where n is negative by taking the reciprocal of x and
    // making n positive.
    // This is done by checking if n is less than 0, and if so, we set x to 1/x and
    // n to -n.
    // We also handle the case where x is 0, in which case the result is 0.
    // Finally, we use a loop to multiply the result by x whenever the current
    // exponent is odd, and square x at each step.
    // This is done using bitwise operations to check if n is odd (n & 1) and to
    // divide n by 2 (n >>= 1).
    // This approach is efficient and works well for large values of n, as it
    // reduces the number of multiplications needed.
    // The time complexity is O(log n) because we are halving the exponent at each
    // step, and the space complexity is O(1) because we are using a constant amount
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 0)
            return 0;

        long N = n;
        double result = 1;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        while (N > 0) {
            if ((N & 1) == 1) {
                result *= x;
            }
            x *= x;
            N >>= 1;
        }

        return result;
    }

    // Test case
    public static void main(String[] args) {
        Solution solution = new Solution();
        double x = 2.0;
        int n = 10;
        System.out.println(solution.myPow(x, n)); // Output: 1024.0
    }
}