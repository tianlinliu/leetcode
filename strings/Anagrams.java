
import java.util.*;

public class Anagrams {
    public static List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if (strs == null) return result;

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            System.out.println(key);
            ArrayList<String> list = null;
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<String>();
            }
            list.add(s);
            map.put(key, list);
        }

        for (ArrayList<String> list : map.values()) {
            if (list.size() > 1) {
                result.addAll(list);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(anagrams(new String[] {"", ""}));
    }
}