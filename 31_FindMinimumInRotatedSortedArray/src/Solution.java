class Solution {
    public int findMin(int[] nums) {
        // Initialize the answer as the minimum element
        int ans = nums[0];
        // Validate the input array
        if (nums.length == 1) {
            return ans;
        }
        // Initialize the left and right pointers
        int left = 0, right = nums.length - 1;

        // Perform binary search
        while (left <= right) {
            // Calculate the middle index
            int mid = left + (right - left) / 2;
            // Update the answer
            ans = Math.min(ans, nums[mid]);
            // Check if the array is rotated
            if (nums[left] <= nums[mid]) {
                // If the left part is sorted, search in the right part
                ans = Math.min(ans, nums[left]);
                left = mid + 1;
            } else {
                // If the right part is sorted, search in the left part
                ans = Math.min(ans, nums[mid]);
                right = mid - 1;
            }
        }

        return ans; // Return the minimum element
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Problem 1
        int[] nums1 = {3, 4, 5, 1, 2};
        // Output: 1
        System.out.println(solution.findMin(nums1));

        // Problem 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        // Output: 0
        System.out.println(solution.findMin(nums2));

        // Problem 3
        int[] nums3 = {11, 13, 15, 17};
        // Output: 11
        System.out.println(solution.findMin(nums3));
    }
}