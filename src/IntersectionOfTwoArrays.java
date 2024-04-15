import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer s1 : set1) {
            if(set2.contains(s1)) {
                result.add(s1);
            }
        }
       return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
