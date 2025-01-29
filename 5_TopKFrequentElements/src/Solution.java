import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // if k is equal to the length of the array, return the array
        if (k == nums.length) {
            return nums;
        }

        // create a hashmap to store the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();

        // iterate through the array and store the frequency of each element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // create a priority queue to store the elements in the array
        // the priority queue will be sorted based on the frequency of the elements
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (n1, n2) -> map.get(n1) - map.get(n2));

        // iterate through the hashmap and add the elements to the priority queue
        for (int num : map.keySet()) {
            pq.add(num);
            // if the size of the priority queue is greater than k,
            // remove the element with the lowest frequency
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // create an array to store the k most frequent elements
        int[] result = new int[k];

        // iterate through the priority queue and add the elements to the array
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        System.out.println(Arrays.toString(solution.topKFrequent(nums, k))); // Output: [1, 2]

        nums = new int[] { 1 };
        k = 1;
        System.out.println(Arrays.toString(solution.topKFrequent(nums, k))); // Output: [1]
    }
}
