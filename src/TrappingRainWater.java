import java.util.Arrays;

public class TrappingRainWater {

    public int trap(int[] height) {
        int volume = 0;
        int leftH;
        int rightH;
        int leftPos = 0;
        int resultVolume = 0;

        for (int i = 1; i < height.length; i++) {
            leftH = height[leftPos];
            rightH = height[i];
            if (leftH > rightH) {
                volume += leftH - rightH;
            }
            if (rightH >= leftH) {
                resultVolume += volume;
                volume = 0;
                leftPos = i;
            }
        }
        int top = leftPos;
        leftPos = height.length - 1;
        volume = 0;
        for (int i = height.length - 1; i > top; i--) {
            leftH = height[leftPos];
            rightH = height[i];
            if (leftH > rightH) {
                volume += leftH - rightH;
            }
            if (rightH >= leftH) {
                resultVolume += volume;
                volume = 0;
                leftPos = i;
            }
        }
        return resultVolume;
    }

}
