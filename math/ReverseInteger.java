public class ReverseInteger {
    public int reverse(int x) {
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x = -x;
        }

        long result = 0;
        while (x > 0) {
            result *= 10;
            result += x % 10;
            x /= 10;
        }

        if (neg) {
            result = -result;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)result;
    }
}