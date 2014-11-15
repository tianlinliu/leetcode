public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s == "") return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.empty() || c != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}