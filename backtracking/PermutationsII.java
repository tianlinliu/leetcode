public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) return result;

        Arrays.sort(num);
        boolean[] visiting = new boolean[num.length];
        List<Integer> list = new ArrayList<>();
        helper(num, list, visiting, result);

        return result;
    }

    private void helper(int[] num, List<Integer> list, boolean[] visiting, List<List<Integer>> result) {
        if (list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
        }

        for (int i = 0; i < num.length; i++) {
            if (visiting[i] || (i > 0 && num[i] == num[i - 1] && !visiting[i - 1])) {  //?
                continue;
            }

            visiting[i] = true;
            list.add(num[i]);
            helper(num, list, visiting, result);
            list.remove(list.size() - 1);
            visiting[i] = false;
        }
    }
}