public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }

        int start = 0;
        int end = nums.length - 1;
        while (start != end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                result = searchAround(mid, nums, target);
                break;
            } else {
                if (nums[mid] > target) {
                    end = mid;
                }
                if (nums[mid] < target) {
                    start = mid;
                }
            }
            if (end - start == 1) {
                break;
            }
        }
        return result;
    }

    public int[] searchAround(int pos, int[] nums, int target) {
        int left = pos;
        int right = pos;
        boolean flag = true;
        boolean leftFlag = false;
        boolean rightFlag = false;
        while (flag) {
            if (left != 0) left--;
            else leftFlag = true;

            if (right != nums.length - 1) right++;
            else rightFlag = true;

            if (nums[left] != target) {
                    left++;
                leftFlag = true;
            }
            if (nums[right] != target) {
                    right--;
                rightFlag = true;
            }
            if (leftFlag && rightFlag) {
                flag = false;
            }
        }
        return new int[]{left , right };
    }

}
