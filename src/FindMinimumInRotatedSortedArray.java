public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i+1] - nums[i] < 0) {
                return i+1;
            }
        }
        return 0;
    }
}
