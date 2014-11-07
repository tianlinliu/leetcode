public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) return result;

        Arrays.sort(num);
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> subset = new ArrayList<>();
        subsetsWithDupHelper(num, 0, subset, set, result);

        return result;
    }

    private void subsetsWithDupHelper(int[] num, int index, List<Integer> subset, HashSet<List<Integer>> set, List<List<Integer>> result) {
        ArrayList<Integer> subsetCheck = new ArrayList<Integer>(subset);
        if (set.add(subsetCheck)) {
            result.add(subsetCheck);
        }

        for (int i = index; i < num.length; i++) {
            subset.add(num[i]);
            subsetsWithDupHelper(num, i + 1, subset, set, result);
            subset.remove(subset.size() - 1);
        }
    }
}