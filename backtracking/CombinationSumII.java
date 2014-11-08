public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) return result;

        Arrays.sort(num);
        List<Integer> path = new ArrayList<>();
        helper(num, target, 0, path, result);

        return result;
    }

    private void helper(int[] num, int target, int index, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        int prev = -1;
        for (int i = index; i < num.length; i++) {
            if (num[i] > target) {
                break;
            }
            if (num[i] == prev) {
                continue;
            }

            path.add(num[i]);
            helper(num, target - num[i], i + 1, path, result);
            path.remove(path.size() - 1);

            prev = num[i];
        }
    }
}