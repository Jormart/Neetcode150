import java.util.*;

// 2021. Meeting Rooms II
// https://leetcode.com/problems/meeting-rooms-ii/
class Solution {
    public class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // This is a solution to the meeting room problem.
    // The problem is to find the minimum number of meeting rooms required to hold
    // all meetings.
    // The approach is to sort the meetings by their start time and then use a list
    // to keep track of the end times of the meetings.
    // If a meeting starts after the earliest ending meeting, we can reuse that
    // room.
    // Otherwise, we need to allocate a new room.
    // The time complexity of this solution is O(n log n) due to the sorting step,
    // and the space complexity is O(n) for storing the end times.
    // The solution uses a greedy approach to find the minimum number of meeting
    // rooms required.
    public int minMeetingRooms(List<Interval> intervals) {
        // If there are no intervals, return 0
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        // Initialize a list to hold the end times of meetings
        List<Integer> endTimes = new ArrayList<>();

        // Sort the intervals by start time
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        // Add the end time of the first meeting
        endTimes.add(intervals.get(0).end);

        // Iterate through the rest of the meetings
        for (int i = 1; i < intervals.size(); i++) {
            Interval currentMeeting = intervals.get(i);
            boolean roomFound = false;

            // Check if any meeting has ended before the current meeting starts
            for (int j = 0; j < endTimes.size(); j++) {
                if (currentMeeting.start >= endTimes.get(j)) {
                    endTimes.set(j, currentMeeting.end);
                    roomFound = true;
                    break;
                }
            }

            // If no room was found, add a new room
            if (!roomFound) {
                endTimes.add(currentMeeting.end);
            }
        }

        // The size of endTimes is the number of rooms needed
        return endTimes.size();
    }

    // Test the solution with a simple example
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(solution.new Interval(0, 30));
        intervals.add(solution.new Interval(5, 10));
        intervals.add(solution.new Interval(15, 20));

        int result = solution.minMeetingRooms(intervals);
        System.out.println("Minimum number of meeting rooms required: " + result); // Output: 2
    }
}
