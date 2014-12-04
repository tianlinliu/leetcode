public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1 || matrix[0].length <= 1) return;

        int n = matrix.length;
        int[] temp = new int[n];
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                temp[j] = matrix[i][j]; // store the top line
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp[j];
            }
        }
    }
}