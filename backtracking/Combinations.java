public class Combinitions {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < 1 || k > n) return result;

        List<Integer> list = new ArrayList<>();
        combineHelper(n, k, 1, list, result);

        return result;
    }

    private void combineHelper(int n, int k, int index, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = index; i <= n; i++) {
            list.add(i);
            combineHelper(n, k, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}