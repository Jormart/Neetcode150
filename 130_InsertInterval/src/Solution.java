import java.util.*;

// 57. Insert Interval
// https://leetcode.com/problems/insert-interval/
class Solution {
    // Interval merging function
    // Time complexity: O(n)
    // Space complexity: O(n)
    // where n is the number of intervals
    // This function takes a list of intervals and a new interval,
    // and returns a new list of intervals after inserting the new interval
    // and merging any overlapping intervals.
    // The function uses a LinkedList to store the merged intervals,
    // which allows for efficient insertion and merging.
    // The function first adds all intervals that come before the new interval,
    // then merges the new interval with any overlapping intervals,
    // and finally adds all intervals that come after the new interval.
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new LinkedList<>();

        // Add all intervals that come before the new interval
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                merged.add(interval);
            } else if (interval[0] > newInterval[1]) {
                merged.add(newInterval);
                newInterval = interval;
            } else {
                // Merge overlapping intervals
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        merged.add(newInterval);

        return merged.toArray(new int[merged.size()][]);
    }

    // Test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        int[][] result = solution.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(result)); // [[1, 5], [6, 9]]
    }
}