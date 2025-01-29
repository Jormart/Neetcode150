import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store the number and its index
        Map<Integer, Integer> map = new HashMap<>();

        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the difference between the target and the current number
            int diff = target - nums[i];

            // If the difference is in the hashmap, return the indices
            if (map.containsKey(diff)) {
                // If found, return the indices of the difference and the current number
                return new int[] { map.get(diff), i };
            }

            // Otherwise, add the number and its index to the hashmap
            map.put(nums[i], i);
        }

        // Return an empty array if no solution is found
        return new int[] {};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // [0, 1]

        nums = new int[] { 3, 2, 4 };
        target = 6;
        result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // [1, 2]

        nums = new int[] { 3, 3 };
        target = 6;
        result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // [0, 1]
    }
}