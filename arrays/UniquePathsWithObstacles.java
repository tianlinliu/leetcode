public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;

        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;

        if (obstacleGrid[0][0] == 1) return 0;

        obstacleGrid[0][0] = 1;
        // set first row
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i - 1][0] == 1 && obstacleGrid[i][0] == 0) {
                obstacleGrid[i][0] = 1;
            } else {
                obstacleGrid[i][0] = 0;
            }
        }

        // first column
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j - 1] == 1 && obstacleGrid[0][j] == 0) {
                obstacleGrid[0][j] = 1;
            } else {
                obstacleGrid[0][j] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }

        return obstacleGrid[m - 1][n - 1];
    }
}