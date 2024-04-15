import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int val : nums) {
            pQueue.add(val);
        }

        for (int i = 0; i < k-1; i++) {
            pQueue.poll();
        }
        return pQueue.poll();
    }

}
