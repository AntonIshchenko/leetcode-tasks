import java.util.Arrays;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxInt = Arrays.stream(height).max().getAsInt();
        int maxV = 0;
        for (int i = 1; i <= maxInt; i++) {
            int leftCol = searchLeft(height, i);
            int rightCol = searchRight(height, i);
            int levelVol = (rightCol - leftCol) * i;
            maxV = Math.max(maxV, levelVol);
        }
        return maxV;
    }

    private int searchLeft(int[] height, int maxVal) {
        for (int i = 0; i < height.length; i++) {
            int cell = height[i] - maxVal;
            if(cell >= 0) {
                return i;
            }
        }
        return -1;
    }

    private int searchRight(int[] height, int maxVal) {
        for (int i = height.length - 1;  i >= 0; i--) {
            int cell = height[i] - maxVal;
            if(cell >= 0) {
                return i;
            }
        }
        return -1;
    }
}
