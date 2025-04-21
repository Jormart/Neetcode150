import java.util.*;

// LeetCode 207. Course Schedule
// https://leetcode.com/problems/course-schedule/
// Given the number of courses and a list of prerequisite pairs, determine if all courses can be finished.
// The problem can be represented as a directed graph where each course is a node and each prerequisite pair is a directed edge.
// We can use Depth-First Search (DFS) to detect cycles in the graph. If a cycle is detected, it means that it's impossible to finish all courses.
// If no cycles are detected, it means that all courses can be finished.
// The time complexity of the algorithm is O(V + E), where V is the number of vertices (courses) and E is the number of edges (prerequisites).
// The space complexity is O(V + E) for the adjacency list representation of the graph and the visited array.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph of courses and prerequisites
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        // Create a visited array to keep track of visited nodes
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecStack = new boolean[numCourses]; // To detect cycles

        // Perform DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(graph, visited, inRecStack, i)) {
                return false; // Cycle detected
            }
        }
        return true; // No cycles detected, all courses can be finished
    }

    private boolean hasCycle(List<List<Integer>> graph, boolean[] visited, boolean[] inRecStack, int course) {
        // Mark the current node as visited and add it to the recursion stack
        visited[course] = true;
        inRecStack[course] = true;

        // Recur for all the vertices adjacent to this vertex
        for (int neighbor : graph.get(course)) {
            if (!visited[neighbor]) {
                if (hasCycle(graph, visited, inRecStack, neighbor)) {
                    return true; // Cycle detected
                }
            } else if (inRecStack[neighbor]) {
                return true; // Cycle detected
            }
        }

        // Remove the vertex from the recursion stack
        inRecStack[course] = false;
        return false; // No cycle detected
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(solution.canFinish(numCourses, prerequisites)); // Output: true

        numCourses = 2;
        prerequisites = new int[][] { { 1, 0 }, { 0, 1 } };
        System.out.println(solution.canFinish(numCourses, prerequisites)); // Output: false
    }
}