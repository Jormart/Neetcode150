import java.util.*;

// 2013. Detect Squares
// https://leetcode.com/problems/detect-squares/

class DetectSquares {

    // Map to store frequency of points: map of x-coordinate to (map of y-coordinate
    // to frequency)
    private Map<Integer, Map<Integer, Integer>> pointsCount;

    public DetectSquares() {
        pointsCount = new HashMap<>();
    }

    // Adds a new point [x, y] to the data structure
    public void add(int[] point) {
        int x = point[0], y = point[1];
        pointsCount.putIfAbsent(x, new HashMap<>());
        pointsCount.get(x).put(y, pointsCount.get(x).getOrDefault(y, 0) + 1);
    }

    // Counts the number of ways to form axis-aligned squares with point [x1, y1]
    public int count(int[] point) {
        int x1 = point[0], y1 = point[1];
        int totalSquares = 0;
        Map<Integer, Integer> yMap = pointsCount.get(x1);
        if (yMap == null)
            return 0;
        for (Map.Entry<Integer, Integer> entry : yMap.entrySet()) {
            int y2 = entry.getKey();
            int countY2 = entry.getValue();
            if (y2 == y1)
                continue;
            int sideLength = Math.abs(y2 - y1);
            // Check right
            int x3 = x1 + sideLength;
            Map<Integer, Integer> yMapX3 = pointsCount.get(x3);
            if (yMapX3 != null) {
                int c1 = yMapX3.getOrDefault(y1, 0);
                int c2 = yMapX3.getOrDefault(y2, 0);
                totalSquares += c1 * c2 * countY2;
            }
            // Check left
            x3 = x1 - sideLength;
            yMapX3 = pointsCount.get(x3);
            if (yMapX3 != null) {
                int c1 = yMapX3.getOrDefault(y1, 0);
                int c2 = yMapX3.getOrDefault(y2, 0);
                totalSquares += c1 * c2 * countY2;
            }
        }
        return totalSquares;
    }

    // Test cases
    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[] { 1, 1 });
        detectSquares.add(new int[] { 2, 2 });
        detectSquares.add(new int[] { 3, 3 });
        System.out.println(detectSquares.count(new int[] { 2, 1 })); // Output: 1
        System.out.println(detectSquares.count(new int[] { 1, 2 })); // Output: 1
        System.out.println(detectSquares.count(new int[] { 3, 2 })); // Output: 0
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */