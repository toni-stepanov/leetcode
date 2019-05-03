package array.merge_intervals_56;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return Integer.compare(a.start, b.start);
        }
    }

    public int[][] merge(int[][] intvls) {
        List<Interval> intervals = new ArrayList<>();
        for (int[] intvl : intvls) {
            intervals.add(new Interval(intvl[0], intvl[1]));
        }
        intervals.sort(new IntervalComparator());
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        int[][] ret = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            ret[i][0] = merged.get(i).start;
            ret[i][1] = merged.get(i).end;
        }
        return ret;
    }

    class Interval {
        int start;
        int end;


        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return String.format("{%1$d, %2$d}", start, end);
        }
    }
}