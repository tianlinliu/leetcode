public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int lo = 0;
        int row = -1;
        while (lo <= m) {
            int mid = lo + (m - lo) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][n]) {
                row = mid;
                break;
            } else if (target > matrix[mid][n]) {
                lo = mid + 1;
            } else {
                m = mid - 1;
            }
        }

        if (row == -1) return false;

        lo = 0;
        while (lo <= n) {
            int mid = lo + (n - lo) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                lo = mid + 1;
            } else {
                n = mid - 1;
            }
        }

        return false;
    }
}