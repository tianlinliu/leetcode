public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (prefix == "") return "";
            prefix = getCommon(prefix, strs[i]);
        }

        return prefix;
    }

    private String getCommon(String prefix, String str) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < Math.min(prefix.length(), str.length()) && prefix.charAt(i) == str.charAt(i)) {
            builder.append(str.charAt(i++));
        }

        return builder.toString();
    }
}