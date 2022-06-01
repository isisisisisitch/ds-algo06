package ca.bytetube._14_dp;

public class MinPathSum {
    public static void main(String[] args) throws Exception {
//        int[][] gid = {{1,2,3}};
//        int[][] gid2 = {{3,4,5}};
//        int[][] gid3 = new int[3][2];
//        System.out.println(gid3[0][0]);
//        int[][] gid4 = new int[3][];
//        gid4[0] = new int[10];
//        gid4[1] = new int[140];
        int[][] gid = {{3}, {4}, {5}};
        int[][] gid1 = {{1, 2, 3}};
        int[][] gid2 = {{3, 1, 0, 2}, {4, 3, 2, 1}, {5, 2, 1, 0}};

        int sum = minPathSum(gid1);
        System.out.println(sum);

    }

    public static int minPathSum(int[][] grid) throws Exception {
        if (grid == null) throw new Exception("error data");

        if (grid.length == 1) {
            int sum = 0;
            for (int i = 0; i < grid[0].length; i++) sum += grid[0][i];
            return sum;
        }
        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];//从左上角点出发到达任意点的最小路径和
        dp[0][0] = grid[0][0];
        //first row
        for (int i = 1; i < col; i++) dp[0][i] = grid[0][i] + dp[0][i - 1];
        //first col
        for (int i = 1; i < row; i++) dp[i][0] = grid[i][0] + dp[i - 1][0];
        //普通位置
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }

        return dp[row - 1][col - 1];

    }


    public static int minPathSum1(int[][] grid) throws Exception {
        if (grid == null) throw new Exception("error data");

        if (grid.length == 1) {
            int sum = 0;
            for (int i = 0; i < grid[0].length; i++) sum += grid[0][i];
            return sum;
        }
        return minPathSum(grid, 0, 0);

    }

    /**
     * minPathSum求解任意(i,j)点到达右下角点的最小路径和
     */
    private static int minPathSum(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];

        //1.last row
        if (i == grid.length - 1) return grid[i][j] + minPathSum(grid, i, j + 1);

        //2.last col
        if (j == grid[0].length - 1) return grid[i][j] + minPathSum(grid, i + 1, j);

        //3.普通位置到达右下角点的最小路径和
        int right = minPathSum(grid, i, j + 1);
        int down = minPathSum(grid, i + 1, j);
        int min = Math.min(right, down);

        return grid[i][j] + min;


    }
}
