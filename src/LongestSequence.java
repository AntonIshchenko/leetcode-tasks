import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSequence {

    // 10^5
    // empty array yes
    public int findSeq(int[] input) {
        if (input.length == 0) {
            return 0;
        }
        Arrays.sort(input);

        int longest = 1;
        int cnt = 1;
        for (int i = 0; i < input.length - 1; i++) {
            int val1 = input[i];
            int val2 = input[i + 1];
            if (val2 - val1 == 1) {
                cnt++;
                longest = Math.max(longest, cnt);
            } else {
                cnt = 1;
            }
        }

        return longest;
    }

    public int findSeqFast(int[] input) {
        if (input.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int val : input) {
            set.add(val);
        }
        int longest = 1;
        // 100, 1, 5, 8, 101 || 100 -> 101 ? ! (cnt++, remove 101) -> 102  ? x -> max(longest, cnt)
        //                       100 -> 99  ? .....
        // 1 2 4 5 ||     4, 5 === 2 ||
        for (Integer val : input) {
            int cnt = 1;
            if (!set.contains(val)) {
                continue;
            }
            cnt += searchLeft(val, set);
            cnt += searchRight(val, set);
            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    private Integer searchRight(Integer val, Set<Integer> set) {
        Integer nextVal = val+1;
        Integer cnt = 0;
        while (set.contains(nextVal)) {
            set.remove(nextVal);
            cnt++;
            nextVal++;
        }
        return cnt;
    }

    private Integer searchLeft(Integer val, Set<Integer> set) {
        set.remove(val);
        Integer nextVal = val-1;
        Integer cnt = 0;
        while (set.contains(nextVal)) {
            set.remove(nextVal);
            cnt++;
            nextVal--;
        }
        return cnt;
    }


    public static void main(String[] args) {
        int seq = new LongestSequence().findSeqFast(new int[]{1,2,4,5});
        System.out.println(seq);
    }

}
