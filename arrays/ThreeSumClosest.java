public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) return -1;

        Arrays.sort(num);
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < num.length - 2; i++) {
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    if (target - sum < minDiff) {
                        minDiff = target - sum;
                        result = sum;
                    }
                    left++;
                } else {
                    if (sum - target < minDiff) {
                        minDiff = sum - target;
                        result = sum;
                    }
                    right--;
                }
            }
        }

        return result;
    }
}