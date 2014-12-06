public class FindPeakElement {
    public int findPeakElement(int[] num) {
        if (num == null || num.length == 0) return -1;

        int low = 0;
        int high = num.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (num[mid] < num[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}