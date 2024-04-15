public class DeleteToZigZagArray {

    public int minimumDeletions(int[] a) {
        int size = a.length;
        if (size == 1) {
            return 0;
        }
        if (size == 2 && a[0] != a[1]) {
            return 0;
        }
        if (size == 2) {
            return 1;
        }
        int numberOfRemoves = 0;
        int currentElement = a[1];
        boolean flip = a[0] > a[1];
        for (int i = 1; i < size - 1; i++) {
            if (flip) {
                if (currentElement > a[i + 1]) {
                    numberOfRemoves++;
                } else {
                    flip = !flip;
                }
            } else {
                if (currentElement < a[i + 1]) {
                    numberOfRemoves++;
                } else {
                    flip = !flip;
                }
            }
            currentElement = a[i+1];
        }
        return numberOfRemoves;
    }
}
