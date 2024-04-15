import java.util.Arrays;

public class BinarySearch {
    public int search(int[] nums, int target) {
        if(target > nums[nums.length-1] || target < nums[0]) {
            return -1;
        }
        if(target == nums[0]) {
            return 0;
        }
        if (target == nums[nums.length-1]) {
            return nums.length-1;
        }
        int left = 0;
        int right = nums.length-1;
        int search = (right - left)/2;
        while(right - left != 1) {
            if(nums[search] > target) {
                right = search;
                search += (left - right)/2;
            } else if (nums[search] < target) {
                left = search;
                search += (right - left)/2;
            } else {
                return search;
            }
        }
        return -1;
    }
}