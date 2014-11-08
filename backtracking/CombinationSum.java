public class CombinationSum {
/*
    combinationSum(candidates, target) {
        result
        list
        helper(candidates, target, list, set, result)
        return result
    }

    helper(candidates, target, list, set, result) {
        if target == 0
            if set.add(list)
                result.add(list)
                return

        for i = 0 to candidates.length
            list.add(candidates[i])
            helper(candidates, target - candidates[i], list, set, result)
            list.remove(candidate[i])
    }
*/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;

        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        helper(candidates, target, 0, list, result);

        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        int prev = -1;
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (candidates[i] == prev) { // track previous element that added to the list
                continue;
            }

            list.add(candidates[i]);
            helper(candidates, target - candidates[i], i, list, result);
            list.remove(list.size() - 1);

            prev = candidates[i];
        }
    }
}