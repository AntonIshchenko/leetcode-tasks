import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindFirstNonRepeatableChar {

    // FIRST NON REPEATABLE CHAR
    // "", null,  "geeksforgeeksfo"
    //  null,  null, r,
    // len < 10^6, only literals, 25 letters

    public Character findFirstChar(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        // value, number of reps, pos
        // hashMap Key = char, Val - Array  [pos] -> -1
        Map<Character, Integer> charMap = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charMap.containsKey(charArray[i])) {
                charMap.put(charArray[i], Integer.MAX_VALUE);
            } else {
                charMap.put(charArray[i], i);
            }
        }

        Character result = null;
        int pos = Integer.MAX_VALUE;
        Set<Character> characters = charMap.keySet();

        for (Character cha : characters) {
            if ( charMap.get(cha) < pos ) {
                pos = charMap.get(cha);
                result = cha;
            }
        }

        return result;
    }
}
