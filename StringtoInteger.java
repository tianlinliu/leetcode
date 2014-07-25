public class StringtoInteger {
    public int atoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;

        int i = 0;
        boolean neg = false;
        if (str.charAt(i) == '-') {
            neg = true;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }

        long result = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + str.charAt(i) - '0';
            i++;
        }

        if (neg) {
            result = -result;
            if (result <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return result >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }
}