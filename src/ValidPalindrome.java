public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < s1.length()/2; i++) {
            if(s1.charAt(i) != s1.charAt(s1.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
