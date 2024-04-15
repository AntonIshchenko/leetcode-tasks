import java.util.Arrays;

public class KClosestPointToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        int [] dists = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            dists[i] = points[i][0]*points[i][0] + points[i][1]*points[i][1];
        }

        int [][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int min  = Integer.MAX_VALUE;
            int pos = -1;
            for (int j = 0; j < points.length; j++) {
                if(dists[j] < min) {
                    min = dists[j];
                    pos = j;
                }
            }
            result[i] = points[pos];
            dists[pos] = Integer.MAX_VALUE;
        }
        return result;
    }

    public int[][] kClosest2(int[][] points, int k) {
        int [] dists = new int[points.length];
        int [] mins = new int[k];
        Arrays.fill(mins, Integer.MAX_VALUE);
        int [][] result = new int[k][2];

        for (int i = 0; i < points.length; i++) {
            dists[i] = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            int max = -1;
            int pos = 0;
            for (int j = 0; j < k; j++) {
                if(max < mins[j] - dists[i] ) {
                    max = mins[j] - dists[i];
                    pos = j;
                }
            }
            if(max > 0) {
                mins[pos] = dists[i];
                result[pos] = points[i];
            }
        }
        return result;
    }
}
