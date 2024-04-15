import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        nums = new int[]{1, 2, 3, 4};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(nums[i]);
            if(integer == null) {
                map.put(nums[i], 1);
            } else {
                return true;
            }
        }
        return false;
    }

}
