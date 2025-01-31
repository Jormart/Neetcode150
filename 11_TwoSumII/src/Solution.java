import java.util.*;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Initialize the left and right pointers
        int left = 0;
        int right = numbers.length - 1;
        // Iterate until left pointer is less than right pointer
        while (left < right) {
            // Calculate the sum of the elements at left and right pointers
            int sum = numbers[left] + numbers[right];
            
            // If the sum is equal to target, return the indices
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }
            // If the sum is less than target, move the left pointer to the right
            else if (sum < target) {
                left++;
            }
            // If the sum is greater than target, move the right pointer to the left
            else {
                right--;
            }
        }
        // Return null if no solution is found
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        // Output: [1, 2]
        System.out.println(Arrays.toString(solution.twoSum(numbers1, target1)));

        // Test 2
        int[] numbers2 = {2, 3, 4};
        int target2 = 6;
        // Output: [1, 3]
        System.out.println(Arrays.toString(solution.twoSum(numbers2, target2)));

        // Test 3
        int[] numbers3 = {-1, 0};
        int target3 = -1;
        // Output: [1, 2]
        System.out.println(Arrays.toString(solution.twoSum(numbers3, target3)));
    }
}