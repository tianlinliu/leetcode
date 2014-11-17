public class 4Sum {
    // HashSet
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length < 4) return result;

        Arrays.sort(num);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < num.length - 3; i++) {
            for (int j = i + 1; j < num.length - 2; j++) {
                int left = j + 1;
                int right = num.length - 1;
                while (left < right) {
                    int sum = num[i] + num[j] + num[left] + num[right];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.addAll(Arrays.asList(num[i], num[j], num[left], num[right]));
                        if (set.add(list)) {
                            result.add(list);
                        }

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    // pruning
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length < 4) return result;

        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < num.length - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = num.length - 1;
                while (left < right) {
                    if (left > j + 1 && num[left] == num[left - 1]) {
                        left++;
                        continue;
                    }
                    if (right < num.length - 1 && num[right] == num[right + 1]) {
                        right--;
                        continue;
                    }

                    int sum = num[i] + num[j] + num[left] + num[right];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.addAll(Arrays.asList(num[i], num[j], num[left], num[right]));
                        result.add(list);

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}