import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        // Check if the array is empty
        if (nums.length == 0) {
            return 0;
        }
        // Create a set to store the numbers
        HashSet<Integer> set = new HashSet<>();
        // Add all the numbers to the set
        for (int num : nums) {
            set.add(num);
        }
        // Initialize the longest sequence length
        int longestSequence = 0;
        // Iterate through the set
        for (int num : set) {
            // Check if the number is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentSequence = 1;
                // Increment the current number and sequence length
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentSequence++;
                }
                // Update the longest sequence length
                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }
        return longestSequence;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        // Output: 4
        System.out.println(solution.longestConsecutive(nums));
    }
}