public class Permutations {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) return result;

        List<Integer> list = new ArrayList<>();
        permuteHelper(num, list, result);

        return result;
    }

    private void permuteHelper(int[] num, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (list.contains(num[i])) {
                continue;
            }

            list.add(num[i]);
            permuteHelper(num, list, result);
            list.remove(list.size() - 1);
        }
    }
}