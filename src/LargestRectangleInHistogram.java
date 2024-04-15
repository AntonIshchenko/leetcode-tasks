import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int maxSquare = 0;
        int level = 1;
        boolean finish = true;
        while(finish) {
            int sum = 0;
            finish = false;
            for (int i = 0; i < heights.length; i++) {
                if (heights[i] != 0) {
                    finish = true;
                    sum++;
                    heights[i]--;
                } else {
                    maxSquare = Math.max(sum * level, maxSquare);
                    sum = 0;
                }
            }
            maxSquare = Math.max(sum * level, maxSquare);
            level++;
        }
        return maxSquare;
    }

    public int largestRectangleAreaFast(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i <= n; i++){
            int currHeight = i == n ? 0 : heights[i];
            while(!st.isEmpty() && currHeight < heights[st.peek()]){
                int top = st.pop();
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                int area = heights[top] * width;
                maxArea = Math.max(area, maxArea);
            }
            st.push(i);
        }
        return maxArea;
    }
}
