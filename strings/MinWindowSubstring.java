public class MinWindowSubstring {
    public String minWindow(String S, String T) {
        if (S == null || T == null || S.length() < T.length()) return "";

        int[] toFind = new int[256];
        for (int i = 0; i < T.length(); i++) {
            toFind[T.charAt(i)]++; //? (int)T.charAt(i)
        }

        int[] found = new int[256];
        String result = "";
        int toFindLen = T.length();
        int start = 0;
        for (int end = start; end < S.length(); end++) {
            int key = S.charAt(end);
            if (toFind[key] != 0) { // S[end] is contained in T
                found[key]++;
                if (found[key] <= toFind[key]) { // find all same char
                    toFindLen--;
                }

                if (toFindLen == 0) { // find all the chars in T
                    while (start < end) {
                        int sKey = S.charAt(start);
                        if (toFind[sKey] == 0) {
                            start++;
                        } else if (found[sKey] > toFind[sKey]){
                            start++;
                            found[sKey]--;
                        } else {
                            break;
                        }
                    }
                    String sub = S.substring(start, end + 1);
                    if (result == "" || sub.length() < result.length()) {
                        result = sub;
                    }

                    // advance start pointer, raise toFindLen to 1
                    found[S.charAt(start++)]--;
                    toFindLen++;
                }
            }
        }

        return result;
    }
}