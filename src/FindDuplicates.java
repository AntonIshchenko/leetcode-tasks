//
//There is an integer array that consists of N+1 elements. Each number from 1 to N is present in the array exactly once
//        except for some number (let's call it M) which is present in the array twice. There are no guarantees for the order of
//        numbers within array. Your task is to find what M is (the value, not the indices).
//
//
//        Examples (for N = 10):
//        _1_ 2 3 4 7 8 9 10 5 _1_ 6
//
//        2 5 _7_ _7_ 8 9 10 1 3 6 4
//
//        4 5 1 _3_ 2 6 8 9 10 7 _3_

public class FindDuplicates {

    public int findDuplicate(int[] input) {
        int[] hist = new int[input.length];
//        for (int i = 0; i < input.length; i++) {
//            hist[i] = 1;
//        }

        for (int i = 0; i < input.length; i++) {
            int val = input[i] - 1;
            if(hist[val] == -1) {
                return val+1;
            }
            hist[val]--;
        }
        return -1;
    }
}
