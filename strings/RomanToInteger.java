public class RomanToInteger {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;

        int prev = rToI(s.charAt(0));
        int result = prev;
        for (int i = 1; i < s.length(); i++) {
            int curr = rToI(s.charAt(i));
            if (curr > prev) {
                result += curr - prev * 2;
            } else {
                result += curr;
            }
            prev = curr;
        }

        return result;
    }

    private int rToI(char c) {
        int i = 0;
        switch(c) {
            case 'I':
                i = 1;
                break;
            case 'V':
                i = 5;
                break;
            case 'X':
                i = 10;
                break;
            case 'L':
                i = 50;
                break;
            case 'C':
                i = 100;
                break;
            case 'D':
                i = 500;
                break;
            case 'M':
                i = 1000;
                break;
        }
        return i;
    }
}