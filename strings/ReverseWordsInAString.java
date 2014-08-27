public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null) return null;
        s = s.trim();
        String[] strs = s.split("\\s+");

        StringBuilder builder = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (i == 0) {
                builder.append(strs[0]);
            } else {
                builder.append(strs[i] + " ");
            }
        }

        return builder.toString();
    }
}