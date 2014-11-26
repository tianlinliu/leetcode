public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows < 1) return result;

        ArrayList<Integer> one = new ArrayList<Integer>();
        one.add(1);
        result.add(one);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = result.get(i - 1);
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= prev.size(); j++) {
                if (j == 0 || j == prev.size()) {
                    cur.add(1);
                } else {
                    cur.add(prev.get(j) + prev.get(j - 1));
                }
            }
            result.add(cur);
        }

        return result;
    }
}