public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;

        int m = grid[0].length;
        int n = grid.length;

        for (int j = 1; j < m; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        if (n == 1) return grid[0][m - 1];

        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        if (m == 1) return grid[n - 1][0];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[n - 1][m - 1];
    }
}