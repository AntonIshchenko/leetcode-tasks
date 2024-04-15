import javafx.collections.transformation.SortedList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopKFrequensElements {

    public int[] topKFrequent(int[] nums, int k) {
        k = 2;
        nums = new int[]{1,1,2,2,2,2,3};
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(sorted[i]);
            if (integer == null) {
                map.put(sorted[i], 1);
            } else {
                map.put(sorted[i], ++integer);
            }
        }
        List<MyPair> sortedPairs = map.keySet().stream().map(e -> new MyPair(e, map.get(e))).collect(Collectors.toList());

        return sortedPairs.stream().sorted().collect(Collectors.toList()).subList(sortedPairs.size() - k, sortedPairs.size()).stream().mapToInt(e -> e.position).toArray();

    }

    class MyPair implements Comparable<MyPair> {
        private int position;
        private int freq;

        public MyPair(int position, int freq) {
            this.position = position;
            this.freq = freq;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyPair myPair = (MyPair) o;
            return position == myPair.position && freq == myPair.freq;
        }

        @Override
        public int hashCode() {
            return Objects.hash(position, freq);
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        @Override
        public int compareTo(MyPair a) {
            return Integer.compare(freq, a.freq);
        }
    }

}
