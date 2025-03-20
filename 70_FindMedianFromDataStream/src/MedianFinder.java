import java.util.PriorityQueue;

class MedianFinder {

    // Time Complexity : O(log n) for addNum and O(1) for findMedian
    // Space Complexity : O(n) for storing the elements
    
    /** initialize your data structure here. */
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num); // Add the element to maxHeap

        minHeap.offer(maxHeap.poll()); // Add the top element of maxHeap to minHeap

        if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll()); // Add the top element of minHeap to maxHeap
        }
    }
    
    // Returns the median of current data stream
    public double findMedian() {
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) * 0.5;
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian()); // 1.5
        obj.addNum(3);
        System.out.println(obj.findMedian()); // 2.0
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
