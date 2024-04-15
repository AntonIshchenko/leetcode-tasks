import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length()-p.length(); i++) {
            if (isAnagram(s.substring(i, i+p.length()), p)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean isAnagram(String s, String t) {
        int[] map = new int[27];
        if (t.length() != s.length()) return false;
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 97]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (--map[s.charAt(i) - 97] < 0)
                return false;
        }
        return true;
    }
}
