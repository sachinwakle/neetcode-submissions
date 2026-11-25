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

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int activeMeetings = 0;
        int minRooms = 0;

        List<Interval> sortedByEnd = new ArrayList<>(intervals);

        intervals.sort(Comparator.comparingInt(a -> a.start));
        sortedByEnd.sort(Comparator.comparingInt(a -> a.end));

        int n = intervals.size();
        int startPointer = 0;
        int endPointer = 0;

        while (startPointer < n && endPointer < n) {
            if (intervals.get(startPointer).start < sortedByEnd.get(endPointer).end) {
                activeMeetings++;
                minRooms = Math.max(minRooms, activeMeetings);

                startPointer++;

            } else {
                activeMeetings--;
                endPointer++;
            }
        }

        return minRooms;
    }
}
