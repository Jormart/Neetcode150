import java.util.*;
// LeetCode 743. Network Delay Time
// https://leetcode.com/problems/network-delay-time/description/
// You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
// We will send a signal from a given node k. Return the time it takes for all the nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create a more memory-efficient adjacency list using primitive arrays instead
        // of objects. Use indices 1 to n to match the problem's node numbering
        int[][] edges = new int[times.length][3];
        int[] edgeCount = new int[n + 1];

        // Count edges per source node
        for (int[] time : times) {
            edgeCount[time[0]]++;
        }

        // Create offset array for edge indexing
        int[] offsets = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            offsets[i + 1] = offsets[i] + edgeCount[i];
        }

        // Copy edges to their positions
        int[] currentOffset = Arrays.copyOf(offsets, n + 1);
        for (int[] time : times) {
            int src = time[0];
            int pos = currentOffset[src]++;
            edges[pos][0] = time[1]; // destination
            edges[pos][1] = time[2]; // weight
        }

        // Distance array - reuse for both distance tracking and visited status
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Use a smaller size priority queue and reuse arrays
        PriorityQueue<int[]> pq = new PriorityQueue<>(Math.min(n, 1000), Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] { k, 0 });

        int visitedCount = 0;
        int maxTime = 0;

        // Process nodes in order of increasing distance
        while (!pq.isEmpty() && visitedCount < n) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            // If this node was already processed with a shorter path, skip it
            if (time > dist[node])
                continue;

            // First time reaching this node with the shortest path
            visitedCount++;
            maxTime = Math.max(maxTime, time);

            // Process adjacent nodes
            for (int i = offsets[node]; i < offsets[node + 1]; i++) {
                int nextNode = edges[i][0];
                int weight = edges[i][1];
                int newDist = time + weight;

                // Only update if we found a shorter path
                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.offer(new int[] { nextNode, newDist });
                }
            }
        }

        // Check if all nodes are reachable
        return visitedCount == n ? maxTime : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4;
        int k = 2;
        System.out.println(solution.networkDelayTime(times, n, k)); // Output: 2
    }
}