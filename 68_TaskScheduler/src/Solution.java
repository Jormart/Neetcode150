import java.util.*;

class Solution {
    // public int leastInterval(char[] tasks, int n) {
    //     // Step 1: Count the frequency of each task
    //     Map<Character, Integer> taskFrequency = new HashMap<>();
    //     for (char task : tasks) {
    //         taskFrequency.put(task, taskFrequency.getOrDefault(task, 0) + 1);
    //     }

    //     // Step 2: Sort the tasks by frequency
    //     List<Integer> taskFrequencyList = new ArrayList<>(taskFrequency.values());
    //     Collections.sort(taskFrequencyList, Collections.reverseOrder());

    //     // Step 3: Calculate the idle slots
    //     int maxFrequency = taskFrequencyList.get(0);
    //     int idleSlots = (maxFrequency - 1) * n;

    //     // Step 4: Fill the idle slots with the remaining tasks
    //     for (int i = 1; i < taskFrequencyList.size(); i++) {
    //         idleSlots -= Math.min(maxFrequency - 1, taskFrequencyList.get(i));
    //     }

    //     // Step 5: Return the total number of slots
    //     return Math.max(0, idleSlots) + tasks.length;
    // }

    public int leastInterval(char[] tasks, int n) {
    // Step 1: Count the frequency of each task
        Map<Character, Integer> taskFrequency = new HashMap<>();
        for (char task : tasks) {
            taskFrequency.put(task, taskFrequency.getOrDefault(task, 0) + 1);
        }

        // Step 2: Build a max heap based on the frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(taskFrequency.values());

        // Step 3: Process the tasks
        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.remove());
                }
            }

            for (int frequency : temp) {
                if (--frequency > 0) {
                    maxHeap.add(frequency);
                }
            }

            cycles += maxHeap.isEmpty() ? temp.size() : n + 1;
        }
        
        return cycles;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Output: 8
        System.out.println(solution.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));

        // Output: 6
        System.out.println(solution.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 0));

        // Output: 16
        System.out.println(solution.leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 2));
    }
}