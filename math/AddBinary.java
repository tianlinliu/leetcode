public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        StringBuilder builder = new StringBuilder();
        int aCur = a.length() - 1;
        int bCur = b.length() - 1;
        int carrier = 0;
        while (aCur >= 0 || bCur >= 0 || carrier == 1) {
            int cur = 0;
            if (aCur >= 0) {
                cur += Character.getNumericValue(a.charAt(aCur));  // (int)(a.charAt(aCur) - '0')
                aCur--;
            }
            if (bCur >= 0) {
                cur += Character.getNumericValue(b.charAt(bCur));
                bCur--;
            }
            if (carrier == 1) {
                cur++;
            }

            carrier = cur / 2;
            cur = cur % 2;
            if (cur == 0) {
                builder.insert(0, "0");
            } else {
                builder.insert(0, "1");
            }
        }

        return builder.toString();
    }
}