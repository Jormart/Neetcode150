
/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
import java.util.*;

public class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

// 252. Meeting Rooms
// https://leetcode.com/problems/meeting-rooms/

class Solution {
    // Method to check if a person can attend all meetings
    // Given a list of intervals representing meeting times, return true if a person
    // can attend all meetings
    // without any overlap, otherwise return false.
    // The method sorts the intervals based on their start time and then checks for
    // any overlapping intervals.
    // If any two intervals overlap, it returns false; otherwise, it returns true.
    // Time complexity: O(n log n) for sorting the intervals
    // Space complexity: O(1) for the sorting operation
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Sort the intervals based on their start time
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start, b.start);
            }
        });

        // Check for overlapping intervals
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false; // Overlapping intervals found
            }
        }

        return true; // No overlapping intervals

    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Interval> intervals1 = new ArrayList<>();
        intervals1.add(new Interval(0, 30));
        intervals1.add(new Interval(5, 10));
        intervals1.add(new Interval(15, 20));
        System.out.println(solution.canAttendMeetings(intervals1)); // false

        List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Interval(7, 10));
        intervals2.add(new Interval(2, 4));
        System.out.println(solution.canAttendMeetings(intervals2)); // true
    }
}
