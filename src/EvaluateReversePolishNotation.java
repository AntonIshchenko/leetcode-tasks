import java.util.HashMap;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int right = stack.poll();
                    int left = stack.poll();
                    stack.push(left + right);
                    break;
                }
                case "-": {
                    int right = stack.poll();
                    int left = stack.poll();
                    stack.push(left - right);
                    break;
                }
                case "*": {
                    int right = stack.poll();
                    int left = stack.poll();
                    stack.push(left * right);
                    break;
                }
                case "/": {
                    int right = stack.poll();
                    int left = stack.poll();
                    stack.push(left / right);
                    break;
                }
                default: {
                    stack.push(Integer.valueOf(token));
                }
            }
        }
        return stack.poll();
    }

}
