import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Create a max heap based on the distance from the origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));

        // Add all points to the max heap and remove the fartherst point if heap size exceeds k
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Collect the k closest points from the max heap
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        int k = 1;
        int[][] result = solution.kClosest(points, k);
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}