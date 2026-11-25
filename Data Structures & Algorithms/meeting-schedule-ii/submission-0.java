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
        int minRooms = 0;
        int counter = 0;

        List<Interval> intervals2 = new ArrayList<>(intervals);

        intervals.sort(Comparator.comparingInt(a -> a.start));
        intervals2.sort(Comparator.comparingInt(a -> a.end));
        int len = intervals.size();

        int i = 0, j = 0;
        while (i < len && j < len) {
            if (intervals.get(i).start < intervals2.get(j).end) {
                counter++;
                minRooms = Math.max(minRooms, counter);
                i++;
            } else {
                counter--;
                j++;
            }
        }

        return minRooms;
    }
}
