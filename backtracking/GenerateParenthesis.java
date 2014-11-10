public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;

        StringBuilder builder = new StringBuilder();
        helper(n, n, builder, result);

        return result;
    }

    private void helper(int left, int right, StringBuilder builder, List<String> result) {
        if (left < 0 || right < 0 || left > right) return;

        if (left == 0 && right == 0) {
            result.add(builder.toString());
            return;
        }

        builder.append("(");
        helper(left - 1, right, builder, result);
        builder.delete(builder.length() - 1, builder.length());

        builder.append(")");
        helper(left, right - 1, builder, result);
        builder.delete(builder.length() - 1, builder.length());

    }
}