import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TheKWeakestRowsInMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        mat = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};

        int[] result = new int[k];
        Arrays.fill(result, -1);
        int cnt = 0;
        int height = mat.length;
        int width = mat[0].length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (mat[j][i] == 0) {
                    if (cnt >= k) return result;
                    if(!contains(result, j))
                        result[cnt++] = j;
                }
            }
        }
        int j = 0;
        while (cnt < k) {
            if(!contains(result, j++))
                result[cnt++] = --j;
        }
        return result;
    }

    private boolean contains(int[] array, int val) {
        for (int j : array) {
            if (j == val) return true;
        }
        return false;
    }
}
