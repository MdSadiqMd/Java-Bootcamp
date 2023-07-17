/*
Approach : The Intervals are overlapped if the startIndex <= LastIndex of other Interval
*** The Approach is applicable if they are only sorted Intervals
 */
import java.util.Arrays;
import java.util.LinkedList;

public class _3_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        _3_Merge_Intervals merger = new _3_Merge_Intervals();

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] mergedIntervals = merger.merge(intervals);

        // Output the merged intervals
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
