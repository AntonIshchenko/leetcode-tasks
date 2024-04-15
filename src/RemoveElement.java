public class RemoveElement {


    public int removeElement(int[] nums, int val) {
        int lastGoodPointer = nums.length - 1;
        int currentPointer = 0;
        if (lastGoodPointer < 0) {
            return 0;
        }
        int mockVal = Integer.MAX_VALUE;

        while (lastGoodPointer != currentPointer) {
            if (nums[currentPointer] != val) {
                currentPointer++;
            } else {
                nums[currentPointer] = nums[lastGoodPointer];
                nums[lastGoodPointer] = mockVal;
                lastGoodPointer--;
            }
        }
        if (nums[currentPointer] != val) {
            currentPointer++;
        } else {
            nums[currentPointer] = nums[lastGoodPointer];
            nums[lastGoodPointer] = mockVal;
        }
        return currentPointer;
    }

}
