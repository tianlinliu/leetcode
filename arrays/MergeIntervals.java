import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    public String toString() {
        return start + " " + end;
    }
}

public class MergeIntervals {
/*
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;

        int mid = intervals.size() / 2;
        for (int i = 0; i < intervals.subList(0, mid).size(); i++) {
            System.out.println(i + ". " + intervals.subList(0, mid).get(i).toString());
        }
        List<Interval> l1 = merge(intervals.subList(0, mid));
        List<Interval> l2 = merge(intervals.subList(mid, intervals.size()));

        return merge(l1, l2);
    }

    private static List<Interval> merge(List<Interval> l1, List<Interval> l2) {
        if (l1.isEmpty()) return l2;
        if (l2.isEmpty()) return l1;

        List<Interval> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size()) {
            Interval inter1 = l1.get(i);
            Interval inter2 = l2.get(j);
            if (inter1.start == inter2.start && inter1.end == inter2.end) {
                result.add(inter1);
                i++;
                j++;
            } else if (inter1.end < inter2.start) {
                result.add(inter1);
                i++;
            } else if (inter2.end < inter1.start) {
                result.add(inter2);
                j++;
            } else {
                Interval newInter = new Interval(Math.min(inter1.start, inter2.start), Math.max(inter1.end, inter2.end));
                l1.set(i, newInter);
                j++;
            }
        }

        while (i < l1.size()) {
            result.add(l1.get(i++));
        }

        while (j < l2.size()) {
            result.add(l2.get(j++));
        }

        return result;
    }

*/

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;

        Collections.sort(intervals, new IntervalComparator());

        List<Interval> result = new ArrayList<Interval>();
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start > prev.end) {
                result.add(prev);
                prev = curr;
            } else {
                prev.end = Math.max(prev.end, curr.end);
            }
        }
        result.add(prev);

        return result;
    }

    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
}