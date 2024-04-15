import java.util.LinkedList;
import java.util.Queue;

public class ValidParentheses {

    public boolean isValid(String s) {
        s = "(){()()}[]";
        if(s.length() < 2)
            return false;
        LinkedList<Character> stack = new LinkedList<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '[' || c == '{' || c == '(') {
                stack.add(c);
            } else {
                Character last = stack.pollLast();
                if (last == null) {
                    return false;
                }
                switch (c) {
                    case ']':
                        if (last != '[')
                            return false;
                        break;
                    case '}':
                        if (last != '{')
                            return false;
                        break;
                    case ')':
                        if (last != '(')
                            return false;
                        break;
                }
            }
        }
        return stack.size() == 0;
    }

}
