package testing.refimpl;

public class ValidPalindromeTest {
    public boolean isPalindrome(String s) {
        String sanitized = s.toLowerCase().replaceAll("[^a-z0-9]+", "");
        int len = sanitized.length();
        int half = len / 2;
        for (int i = 0; i < half; ++i) {
            if (sanitized.charAt(i) != sanitized.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
