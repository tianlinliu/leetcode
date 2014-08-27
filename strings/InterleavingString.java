public class InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        if (s3.length() != s1.length() + s2.length()) return false;

        StringBuilder builder = new StringBuilder(s3);
        for (int i = 0; i < s1.length(); i++) {
            int index = builder.indexOf(String.valueOf(s1.charAt(i)));
            if (index >= 0) {
                builder.deleteCharAt(index);
            } else {
                return false;
            }
        }

        return builder.toString().equals(s2);
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aa", "ab", "aaba"));
    }
}