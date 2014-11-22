import java.util.*;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        if (n < 1 || n > 9 || k < 1) return "";

        StringBuilder builder = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        get(n, k, builder, result);
        return result.get(k - 1);
    }

    private static void get(int n, int k, StringBuilder builder, ArrayList<String> result) {
        System.out.println(builder.toString());

        if (builder.length() == n) {
            result.add(builder.toString());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (builder.indexOf(String.valueOf(i)) != -1) {
                continue;
            }

            builder.append(i);
            get(n, k, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 1));
    }
}