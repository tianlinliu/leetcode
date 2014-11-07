public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<>();
        if (S == null || S.length == 0) return result;

        Arrays.sort(S);
        List<Integer> subset = new ArrayList<>();
        subsetsHelper(S, 0, subset, result);

        return result;
    }

    private void subsetsHelper(int[] S, int index, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(subset));

        for (int i = index; i < S.length; i++) {
            subset.add(S[i]);
            subsetsHelper(S, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}