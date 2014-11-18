public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) return -1;
        if (target < A[0]) return 0;

        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}