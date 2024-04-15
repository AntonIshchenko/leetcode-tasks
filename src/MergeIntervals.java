import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        if(intervals.length < 2) {
            return intervals;
        }
        int [][] result = new int[intervals.length][2];
        int [] first = intervals[0];
        int [] second = intervals[1];
        int pos = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(first[1] >= second[0]) {
                first = mergeTwo(first, second);
                result[pos] = first;
            } else {
                result[pos++] = first;
                result[pos++] = second;
                first = intervals[i];
                if(i == intervals.length - 1){
                    result[pos] = first;
                } else {
                    second = intervals[i+1];
                }
            }
        }
        return Arrays.copyOf(result, pos+1);
    }

    int [] mergeTwo(int[] a, int[] b) {
        return new int[] {a[0], b[1]};
    }
}
