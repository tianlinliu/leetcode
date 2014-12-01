public class SearchRange {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        result[0] = searchFirst(A, target);
        result[1] = searchLast(A, target);

        return result;
    }

    private int searchFirst(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        if (A[low] != target) {
            return -1;
        } else {
            return low;
        }
    }

    private int searchLast(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int mid = low + (high - low) + 1 / 2;
            if (A[mid] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        if (A[high] != target) return -1;
        return high;
    }
}