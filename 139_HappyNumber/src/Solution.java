import java.util.*;

// 202. Happy Number
// https://leetcode.com/problems/happy-number/
class Solution {
    // Approach using Floyd's Cycle Detection Algorithm
    // 1. Initialize two pointers, slow and fast.
    // 2. Move slow by one step and fast by two steps until they meet or fast
    // becomes 1.
    // 3. If they meet, return false (not a happy number).
    // 4. If fast becomes 1, return true (happy number).
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while (slow != fast && fast != 1);
        return fast == 1;
    }

    private int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19)); // true
        System.out.println(solution.isHappy(2)); // false
        System.out.println(solution.isHappy(7)); // true
        System.out.println(solution.isHappy(4)); // false
    }
}