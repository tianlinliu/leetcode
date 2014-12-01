public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) return -1;

        int low = 0;
        int high = num.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (num[mid] > num[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return num[low];
    }
}