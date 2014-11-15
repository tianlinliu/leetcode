public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            char sChar = s.charAt(start);
            char eChar = s.charAt(end);
            if (!Character.isLetterOrDigit(sChar)) { // include digits
                start++;
            } else if (!Character.isLetterOrDigit(eChar)) {
                end--;
            } else if (Character.toLowerCase(sChar) != Character.toLowerCase(eChar)) {
                return false;
            } else {
                start++;
                end--;
            }
        }

        return true;
    }
}