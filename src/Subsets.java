import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        recursive("");
        return result;
    }

    public void recursive(String currentString) {
        List<Integer> subset = new ArrayList<>();

        if (currentString.length() == nums.length) {
            char[] charArray = currentString.toCharArray();
            for (int i = 0; i < nums.length; i++) {
                if (charArray[i] == '1') {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
            return;
        }

        recursive(currentString + "0");
        recursive(currentString + "1");
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

//        backtrack(0, result);

        return result;
    }

    public void backtrack(int step, List<List<Integer>> result, int[] nums, List<Integer> subset) {

        if (step == nums.length) {
            result.add(subset);
        } else {
            subset.add(nums[step]);
            backtrack(step + 1, result, nums, subset);
            subset.remove(subset.size() - 1);
            backtrack(step + 1, result, nums, subset);
        }
    }
}

