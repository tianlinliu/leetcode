public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) return -1;

        int lo = 0;
        int hi = num.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (num[mid] == num[hi]) {
                hi--;
            } else if (num[mid] > num[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return num[lo];
    }
}