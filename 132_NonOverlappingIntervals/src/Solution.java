import java.util.Arrays;

// 435. Non-overlapping Intervals
//https://leetcode.com/problems/non-overlapping-intervals/description/

class Solution {
    // This function returns the minimum number of intervals to remove to make the
    // rest non-overlapping
    // It sorts the intervals based on their end times and then iterates through
    // them
    // If the start time of the current interval is less than the end time of the
    // last added interval,
    // it means they overlap, so we increment the count of intervals to remove
    // Otherwise, we update the end time to the end time of the current interval
    // Time complexity: O(n log n) due to sorting the intervals
    // Space complexity: O(1) since we are using only a few extra variables
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Sort intervals based on the end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }

        return count;
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(solution.eraseOverlapIntervals(intervals)); // Output: 1
    }
}