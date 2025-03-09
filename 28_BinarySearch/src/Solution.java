class Solution {
    public int search(int[] nums, int target) {
        // Intialize the left and right pointers
        int left = 0, right = nums.length - 1;

        // Loop until the left pointer is less than or equal to the right pointer
        while (left <= right) {
            // Calculate the mid pointer
            int mid = left + (right - left) / 2;

            // If the mid element is equal to the target, return the mid pointer
            if (nums[mid] == target) {
                return mid;
                // If the mid element is less than the target, move the left pointer to mid + 1
            } else if (nums[mid] < target) {
                left = mid + 1;
                // If the mid element is greater than the target, move the right pointer to mid
                // - 1
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        System.out.println(solution.search(nums, target)); // Output: 4

        nums = new int[] { -1, 0, 3, 5, 9, 12 };
        target = 2;
        System.out.println(solution.search(nums, target)); // Output: -1
    }
}