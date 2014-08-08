import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> list = new ArrayList<>();
        if (num == null || num.length < 3) return list;

        Arrays.sort(num);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < num.length - 2; i++) {
            int low = i + 1;
            int high = num.length - 1;
            while (low < high) {
                int sum = num[i] + num[low] + num[high];
                if (sum == 0) {
                    List<Integer> triList = Arrays.asList(num[i], num[low], num[high]);
                    if (set.add(triList)) {
                        list.add(triList);
                    }
                    low++;
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return list;
    }
}