public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int [] map = new int[26];
        if (t.length() != s.length()) return false;
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 97]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(--map[s.charAt(i)- 97] < 0)
                return false;
        }
        return true;
    }

}
