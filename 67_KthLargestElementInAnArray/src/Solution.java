import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // The min-heap will store the k largest elements
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element to maintain the size of the min-heap
            }
        }

        // The root of the min-heap is the kth smallest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3,2,1,5,6,4};
        int k = 3;
        System.out.println(sol.findKthLargest(nums, k)); // Output: 5
    }
}