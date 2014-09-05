public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) return -1;  //?

        int result = 0;
        for (int i = 0; i < num - 2; i++) {
            int low = i + 1;
            int high = num.length - 1;
            while (low < high) {
                int sum = num[i] + num[low] + num[high];
                int diff = Math.abs(sum - target) - Math.abs(result - target);
                if (diff == 0) {
                    return target;
                } else if (diff < 0) {
                    result = sum;
                }
            }
        }

    }
}