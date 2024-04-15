import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static java.util.Collections.singletonList;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams2(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        List<List<String>> result = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if (map.containsKey(sorted)) {
                List<Integer> pos = map.get(sorted);
                pos.add(i);
                map.put(sorted, pos);
            } else {
                ArrayList<Integer> objects = new ArrayList<>();
                objects.add(i);
                map.put(sorted, objects);
            }
        }

        Set<String> strings = map.keySet();

        for (String key : strings) {
            List<Integer> integers = map.get(key);
            List<String> setOf = new ArrayList<>();
            for (Integer position :
                    integers) {
                setOf.add(strs[position]);
            }
            result.add(setOf);
        }
        return  result;
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (Objects.equals(strs[i], "{")) continue;
            ArrayList<String> list = new ArrayList<>();
            list.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (!Objects.equals(strs[i], "{") && isAnagram(strs[i], strs[j])) {
                    list.add(strs[j]);
                    strs[j] = "{";
                }
            }
            result.add(list);
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
            if (--map[s.charAt(i) - 97] < 0) return false;
        }
        return true;
    }

}
