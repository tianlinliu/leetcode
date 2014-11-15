public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int longest = 0;
        int start = 0;
        HashSet<Character> set = new HashSet<>();
        for (int end = 0; end < s.length(); end++) {
            if (set.add(s.charAt(end))) {
                int size = set.size();
                if (size > longest) {
                    longest = size;
                }
            } else {
                while (start < end && s.charAt(start) != s.charAt(end)) {
                    set.remove(s.charAt(start++));
                }
                start++;
            }
        }

        return longest;
    }
}