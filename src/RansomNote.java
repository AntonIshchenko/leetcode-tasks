import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] histogram = new int[200];

        for (char c : magazine.toCharArray()) {
            histogram[c - 97]++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            histogram[magazine.charAt(i)]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (histogram[ransomNote.charAt(i)]-- == 0) return false;
        }
        return true;
    }

}
