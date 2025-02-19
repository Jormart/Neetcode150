class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // If the first array is greater than the second array, then swap them
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // Length of the first array and second array
        int x = nums1.length, y = nums2.length;
        // Low and high pointers for binary search
        int low = 0, high = x;
        
        // Binary search to find the partition
        while (low <= high) {
            // Partition of the first array
            int partitionX = (low + high) / 2;
            // Partition of the second array
            int partitionY = (x + y + 1) / 2 - partitionX;
            // If partitionX is 0, then there is no element on the left side. Use -INF for maxLeftX
            // If partitionX is equal to the length of the first array, then there is no element on the right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            // If partitionY is 0, then there is no element on the left side. Use -INF for maxLeftY
            // If partitionY is equal to the length of the second array, then there is no element on the right side. Use +INF for minRightY
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
            // If both the left sides are less than the right sides, then we have found the correct partition
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // If the combined length of the arrays is even, then return the average of the maximum of the left sides and the minimum of the right sides
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                }
                // If the combined length of the arrays is odd, then return the maximum of the left sides
                else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            }
            // If the left side of the first array is greater than the right side of the second array, then move the high pointer to the left
            else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            }
            // If the right side of the first array is less than the left side of the second array, then move the low pointer to the right
            else {
                low = partitionX + 1;
            }
        }

        // If the arrays are not sorted, then return -1
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(nums3, nums4));
    }
}