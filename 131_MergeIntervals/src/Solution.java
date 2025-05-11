import java.util.*;

// 56. Merge Intervals
// https://leetcode.com/problems/merge-intervals/description/
class Solution {
    // The function takes a 2D array of intervals and merges overlapping intervals.
    // It sorts the intervals based on the start time and then iterates through
    // them,
    // merging them if they overlap. The merged intervals are returned as a 2D
    // array.
    // The algorithm uses a greedy approach to solve the problem.
    // The intervals are sorted based on the start time, and then we iterate through
    // the sorted intervals to merge them. If the current interval overlaps with the
    // last merged interval, we merge them by updating the end time of the last
    // merged interval. If there is no overlap, we simply add the current interval
    // to the merged list. The final merged intervals are returned as a 2D array.
    // The time complexity of this algorithm is O(n log n) due to the sorting step,
    // and the space complexity is O(n) for the merged list.

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                // There is an overlap, so we merge the current interval with the last one
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] merged1 = solution.merge(intervals1);
        System.out.println(Arrays.deepToString(merged1)); // [[1, 6], [8, 10], [15, 18]]

        int[][] intervals2 = { { 1, 4 }, { 4, 5 } };
        int[][] merged2 = solution.merge(intervals2);
        System.out.println(Arrays.deepToString(merged2)); // [[1, 5]]
    }
}