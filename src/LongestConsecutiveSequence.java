import java.util.Arrays;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        if(nums.length == 0) {
            return 0;
        }
        int[] sortedArray = Arrays.stream(nums).sorted().toArray();
        int maxVal = 0;
        int cnt = 1;
        int cur;
        int next;

        for (int i = 0; i < sortedArray.length - 1; i++) {
            cur = sortedArray[i];
            next = sortedArray[i + 1];
            if (next - cur == 1) {
                cnt++;
            } else {
                if (cnt > maxVal)
                    maxVal = cnt;
                cnt = 1;
            }

        }
        if (cnt > maxVal)
            maxVal = cnt;
        return maxVal;
    }
}
