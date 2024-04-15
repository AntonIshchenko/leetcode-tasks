import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public FindMedianFromDataStream() {
        left = new PriorityQueue<>(Comparator.reverseOrder());
        right = new PriorityQueue<>(Comparator.naturalOrder());
    }

    public void addNum(int num) {
//        if()
    }

    public double findMedian() {
        int size = left.size();
        PriorityQueue<Integer> findQueue = new PriorityQueue<>(left);

        for (int i = 0; i < size / 2 - 1; i++) {
            findQueue.poll();
        }

        if (size % 2 == 0) {
            return ((double) findQueue.poll() + findQueue.poll()) / 2;
        } else {
            Integer pollIfOnly = findQueue.poll();
            return findQueue.isEmpty() ? pollIfOnly : findQueue.poll();
        }
    }
}
