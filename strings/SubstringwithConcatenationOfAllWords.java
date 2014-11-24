import java.util.*;

public class SubstringwithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<>();
        if (S == null || L == null) return result;

        int len = L.length;
        int wordLen = L[0].length();
        if (S.length() < len * wordLen) return result;

        HashMap<String, Integer> toFind = new HashMap<>();
        for (String s : L) {
            if (!toFind.containsKey(s)) {
                toFind.put(s, 1);
            } else {
                toFind.put(s, toFind.get(s) + 1);
            }
        }

        HashMap<String, Integer> found = new HashMap<>();
        for (int start = 0; start <= S.length() - len * wordLen; start++) {
            found.clear();
            for (int i = 0; i < len; i++) {
                int end = start + i * wordLen;
                String word = S.substring(end, end + wordLen);
                if (!toFind.containsKey(word)) {
                    break;
                }

                if (!found.containsKey(word)) {
                    found.put(word, 1);
                } else {
                    found.put(word, found.get(word) + 1);
                }

                if (found.get(word) > toFind.get(word)) {
                    break;
                }

                if (i == len - 1) {
                    result.add(start);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String S = "barfoothefoobarman";
        String[] L = {"foo", "bar"};
        System.out.println(findSubstring(S, L));
    }
}