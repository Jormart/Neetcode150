import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Create a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the max heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Continously remove and smash the two heaviest stones until there is one stone left
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.remove(); // The heaviest stone
            int stone2 = maxHeap.remove(); // The second heaviest stone

            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2); // Add the remaining stone to the max heap
            }
        }

        // Return the last stone if it exists
        return maxHeap.isEmpty() ? 0 : maxHeap.remove();   
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test 1
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        // Output: 1
        System.out.println(sol.lastStoneWeight(stones1));

        // Test 2
        int[] stones2 = {2, 2};
        // Output: 0
        System.out.println(sol.lastStoneWeight(stones2));
    }
}