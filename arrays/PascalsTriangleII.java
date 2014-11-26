public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0) return result;

        result.add(1);
        for (int i = 0; i < rowIndex; i++) {
            int prev = 1;
            for (int j = 1; j < result.size(); j++) {
                int cur = result.get(j);
                result.set(j, prev + cur);
                prev = cur;
            }
            result.add(1);
        }

        return result;
    }
}