import java.util.*;
// 1851. Minimum Interval to Include Each Query
// https://leetcode.com/problems/minimum-interval-to-include-each-query/description/

class Solution {
    // Function to find the minimum interval for each query
    // The function takes a 2D array of intervals and an array of queries
    // It returns an array of integers where each element is the size of the
    // minimum interval that includes the corresponding query
    // If no such interval exists, it returns -1 for that query
    // Time complexity: O((m + n) log m), where m is the number of intervals and n
    // is the number of queries
    // Space complexity: O(m + n), for storing the intervals and queries
    // where m is the number of intervals and n is the number of queries
    // The function uses a min-heap to efficiently find the minimum interval
    // that includes each query
    // The intervals are sorted by their starting points, and the queries are
    // sorted by their values
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[] result = new int[n];

        // Store the original indices of the queries for correct answer order
        Integer[] queryIndices = new Integer[n];
        for (int i = 0; i < n; i++) {
            queryIndices[i] = i;
        }
        // Sort the intervals by their starting points, and by size if starting points
        // are equal
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Sort the queries and maintain their original indices
        Arrays.sort(queryIndices, (a, b) -> Integer.compare(queries[a], queries[b]));

        // Min-heap to store the intervals based on their size
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));
        int intervalIndex = 0;

        // Process each query in sorted order
        for (int i = 0; i < n; i++) {
            int queryIndex = queryIndices[i];
            int queryValue = queries[queryIndex];

            // Add all intervals that start before or at the current query value
            while (intervalIndex < intervals.length && intervals[intervalIndex][0] <= queryValue) {
                minHeap.offer(intervals[intervalIndex]);
                intervalIndex++;
            }

            // Remove intervals from the heap that end before the current query value
            while (!minHeap.isEmpty() && minHeap.peek()[1] < queryValue) {
                minHeap.poll();
            }

            // Store the result for the current query
            if (minHeap.isEmpty()) {
                result[queryIndex] = -1; // No interval covers this query
            } else {
                int[] minInterval = minHeap.peek();
                result[queryIndex] = minInterval[1] - minInterval[0] + 1; // Size of the minimum interval
            }
        }
        // Fill in the result for queries that have no covering interval
        for (int i = 0; i < n; i++) {
            if (result[i] == 0) {
                result[i] = -1; // No interval covers this query
            }
        }

        return result;
    }

    // Test case
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = { { 1, 4 }, { 2, 4 }, { 3, 6 } };
        int[] queries = { 2, 3, 4, 5 };
        int[] result = solution.minInterval(intervals, queries);
        System.out.println(Arrays.toString(result)); // Output: [3, 3, 3, 4]
    }
}