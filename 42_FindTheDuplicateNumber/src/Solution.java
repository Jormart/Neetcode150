class Solution {
    public int findDuplicate(int[] nums) {
        // Initialize the slow and fast pointers
        int slow = nums[0];
        int fast = nums[nums[0]];

        // Find the intersection point of the two runners
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // Find the "entrance" to the cycle
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // Return the duplicate element
        return slow;
    }

    // public int findDuplicate(int[] nums) {
    // // Initialize the hare and tortoise pointers
    // int tortoise = nums[0];
    // int hare = nums[0];
    // // The hare moves twice as quickly as the tortoise
    // while (true) {
    // tortoise = nums[tortoise];
    // hare = nums[nums[hare]];
    // if (tortoise == hare) {
    // break;
    // }
    // }
    // // Find the "entrance" to the cycle
    // tortoise = nums[0];
    // while (tortoise != hare) {
    // tortoise = nums[tortoise];
    // hare = nums[hare];
    // }
    // // Return the duplicate element
    // return hare;
    // }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println(sol.findDuplicate(nums));

        int[] nums2 = { 3, 1, 3, 4, 2 };
        System.out.println(sol.findDuplicate(nums2));
    }
}