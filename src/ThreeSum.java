import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        int[] arr = Arrays.stream(nums).sorted().toArray();

        int mid = -1;
        int zer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zer++;
            }
            if (arr[i] > 0 && Math.abs(arr[i]) == arr[i]) {
                mid = i;
                break;
            }
        }
        if (mid < 0 && zer >= 3) {
            result.add(Arrays.asList(0, 0, 0));
            return new ArrayList<>(result);
        }
        if (mid < 0 && zer < 3) {
            return new ArrayList<>();
        }
        if (mid > 0 && zer >= 3) {
            result.add(Arrays.asList(0, 0, 0));
        }
        int[] positive = Arrays.copyOfRange(arr, mid, arr.length);
        for (int i = 0; i < arr.length && arr[i] <= 0; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum2 = arr[i] + arr[j];
                int el3Pos = Arrays.binarySearch(positive, sum2 * (-1));
                if (el3Pos < 0) {
                    continue;
                }
                int realPos = mid + el3Pos;
                if (realPos != i && realPos != j) {
                    List<Integer> list = Arrays.asList(arr[i], arr[j], arr[realPos]);
                    Collections.sort(list);
                    result.add(list);
                }
            }
        }
        return new ArrayList<>(result);
    }


    public List<List<Integer>> threeSumLongTime(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] > 0) {
                break;
            }
            for (int j = i + 1; j < sorted.length; j++) {
                for (int k = j + 1; k < sorted.length; k++) {
                    if (sorted[i] + sorted[j] + sorted[k] == 0) {
                        result.add(List.of(sorted[i], sorted[j], sorted[k]));
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSumFasterButSlow(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        int[] arr = Arrays.stream(nums).sorted().toArray();
        List<Integer> sorted = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        int i = 0;
        while (i < arr.length && sorted.get(i) <= 0) {
            for (int j = i + 1; j < sorted.size(); j++) {
                int toFind = (sorted.get(i) + sorted.get(j)) * (-1);
                int firstIndex = sorted.indexOf(toFind);
                if (firstIndex < 0) {
                    continue;
                }
                if (firstIndex != i && firstIndex != j) {
                    List<Integer> list = Arrays.asList(sorted.get(i), sorted.get(j), sorted.get(firstIndex));
                    Collections.sort(list);
                    result.add(list);
                }
            }
            i++;
        }
        return new ArrayList<>(result);
    }
}
