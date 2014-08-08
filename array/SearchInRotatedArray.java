public class SearchInRotatedArray {
    public static int search(int[] arr, int target) {
        if (arr == null) return -1;
        return search(arr, target, 0, arr.length - 1);
    }

    private static int search(int[] arr, int target, int left, int right) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;

        // left part is sorted
        if (arr[left] <= arr[mid]) {
            if (arr[left] <= target && arr[mid] > target) {
                return search(arr, target, left, mid - 1);
            } else {
                return search(arr, target, mid + 1, right);
            }
        } else { // right part is sorted
            if (arr[mid] < target && arr[right] >= target) {
                return search(arr, target, mid + 1, right);
            } else {
                return search(arr, target, left, mid - 1);
            }
        }
    }
}