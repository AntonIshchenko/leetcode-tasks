import java.util.Objects;
import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        for (char charArray : charArrayS) {
            if (charArray == '#') {
                if (!stack1.isEmpty()) stack1.pop();
            } else {
                stack1.push(charArray);
            }
        }
        for (char value : charArrayT) {
            if (value == '#') {
                if (!stack2.isEmpty()) stack2.pop();
            } else {
                stack2.push(value);
            }
        }

        if (stack2.size() != stack1.size()) {
            return false;
        }


        return Objects.equals(stack1.toString(), stack2.toString());
    }
}
