public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n < 0) return result;

        result.add(0);
        if (n == 0) return result;

        result.add(1);
        // first reverse previous list, then add the first digit, append it to the result list
        for (int i = 2; i <= n; i++) {
            List<Integer> reverse = reverseList(result);
            for (int j = 0; j < reverse.size(); j++) {
                reverse.set(j, reverse.get(j) + (int)Math.pow(2, i - 1)); // Math.pow() => return type: double
            }
            result.addAll(reverse);
        }

        return result;
    }

    private List<Integer> reverseList(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }

        return result;
    }
}