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

    public static List<List<Integer>> threeSum_binarySearch(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length < 3) return res;

        Arrays.sort(num);
        int one = 0;
        int three = num.length - 1;
        Set<List<Integer>> set = new HashSet<>();
        while (one < three - 1)) {
            int target = -(num[one] + num[three]);
            int two = search(num, target, i + 1, num.length - 3)
            if (two != -1) {
                List<Integer> tri = Arrays.asList(num[one], num[two], num[three]);
                if (set.add(tri)) {
                    res.add(tri);
                }
                one++;
                three--;
            } else {
                one++;
            }
        }
    }

    private static int search(int[] num, int target, int low, int high) {
        if
    }
}