class Solution {
    public int search(int[] nums, int target) {
        // Initialize the left and right pointers
        int left = 0, right = nums.length - 1;

        // Iterate until the left pointer is less than or equal to the right pointer
        while (left <= right) {
            // Calculate the middle index
            int mid = left + (right - left) / 2;
            // If the middle element is equal to the target, return the index
            if (nums[mid] == target) {
                return mid;
            }
            // If the left element is less than the middle element
            if (nums[left] <= nums[mid]) {
                // If the target is greater than or equal to the left element and less than the middle element
                if (nums[left] <= target && target < nums[mid]) {
                    // Update the right pointer
                    right = mid - 1;
                } else {
                    // Update the left pointer
                    left = mid + 1;
                }
            } else {
                // If the target is greater than the middle element and less than or equal to the right element
                if (nums[mid] < target && target <= nums[right]) {
                    // Update the left pointer
                    left = mid + 1;
                } else {
                    // Update the right pointer
                    right = mid - 1;
                }
            }
        }

        // Return -1 if the target is not found
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Should be 4
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));

        // Should be -1
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}