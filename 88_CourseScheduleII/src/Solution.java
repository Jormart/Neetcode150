// Problem: 210. Course Schedule II
// Link: https://leetcode.com/problems/course-schedule-ii/

import java.util.*;

class Solution {
    // Space-optimized solution using Kahn's Algorithm (BFS Topological Sort)
    // Time Complexity: O(V + E), Space Complexity: O(V + E) but with optimized
    // memory usage
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Count total edges to initialize arrays with exact sizes
        int totalEdges = prerequisites.length;

        // Create compact adjacency representation using arrays instead of nested lists
        // edges[i] stores the starting index in the adjacencyList for course i
        int[] edges = new int[numCourses + 1];
        int[] adjacencyList = new int[totalEdges];
        int[] inDegree = new int[numCourses];

        // Count in-degrees and prepare edges array
        for (int[] prereq : prerequisites) {
            inDegree[prereq[0]]++;
        }

        // Calculate starting indices for each course in the adjacencyList
        for (int[] prereq : prerequisites) {
            edges[prereq[1] + 1]++;
        }
        for (int i = 1; i <= numCourses; i++) {
            edges[i] += edges[i - 1];
        }

        // Build the adjacency list
        int[] edgesCopy = Arrays.copyOf(edges, edges.length);
        for (int[] prereq : prerequisites) {
            adjacencyList[edgesCopy[prereq[1]]++] = prereq[0];
        }

        // Use ArrayDeque instead of LinkedList for better memory efficiency
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[idx++] = course;

            // Process all neighbors of this course
            int start = edges[course];
            int end = edges[course + 1];
            for (int i = start; i < end; i++) {
                int nextCourse = adjacencyList[i];
                if (--inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // If we couldn't process all courses, there must be a cycle
        return idx == numCourses ? result : new int[0];
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
        int[] result = solution.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(result)); // Output: [0, 1, 2, 3]
    }
}