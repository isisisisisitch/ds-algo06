package ca.bytetube._11_backtracking;

/**
 * https://leetcode.com/problems/n-queens-ii/
 *
 * @author dal
 */
public class NQueens {
    public static void main(String[] args) {
        new NQueens().totalNQueens(8);
    }


    //int[][] matrix;
    //index: 行号， value：列号  cols[4] = 5;表示在棋盘的第四行第五列安放了一个皇后
    int[] cols;

    int ways;

    public int totalNQueens(int n) {
        if (n < 1) return 0;
        //matrix = new int[0][3];
        cols = new int[n];
        place(0);

        return ways;
    }

    /**
     * @param row 从第n行开始摆放皇后
     */
    private void place(int row) {
        if (row == cols.length ) {
            ways++;
            show();
            return;
        }

        for (int col = 0; col < cols.length; col ++) {
            if (isValid(row,col)) {//(4,4)
                cols[row] = col;//在第row行第col列安放了一个皇后
                place(row + 1);//5
            }

        }

    }


    /**
     *pruning
     * 行不用考虑
     * 需要考虑列和对角线
     */
    private boolean isValid(int row, int col) {
        // i表示已经走过的行 因为皇后是从第0行开始向下摆放的，所以需要看之前所有行行后的摆放位置
        for (int i = 0; i < row; i++) {
            //需要考虑列
           // cols[2] = 4;
            if ( cols[i] == col) return false;


            //需要考虑对角线
            if (Math.abs(col - cols[i]) == row - i) return false;

        }

        return true;
    }

    public void show(){
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col)  System.out.print("1 ");
                else System.out.print("0 ");

            }
            System.out.println();

        }
        System.out.println("======================================");
    }
}
