public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int len = 0;
        // calculate the length of number
        while (x / Math.pow(10, len + 1) >= 1) {
            len++;
        }

        while (len > 0) {
            int first = (int)(x / Math.pow(10, len));
            int last = (int)(x % 10);
            if (first == last) { // test if the first num == last one
                x -= first * Math.pow(10, len);
                x /= 10;
                len -= 2;
            } else {
                return false;
            }
        }

        return true;
    }
}