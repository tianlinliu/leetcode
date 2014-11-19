/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) return intervals;
        if (intervals.isEmpty()) {
            intervals.add(newInterval);
            return intervals;
        }

        int i = 0;
        while (i < intervals.size()) {
            Interval curInterval = intervals.get(i);
            if (newInterval.start > curInterval.end) {
                i++;
            } else if (newInterval.end < curInterval.start) {
                break;
            } else {
                newInterval.start = Math.min(curInterval.start, newInterval.start);
                newInterval.end = Math.max(curInterval.end, newInterval.end);
                intervals.remove(curInterval);
            }
        }
        intervals.add(i, newInterval);

        return intervals;
    }
}