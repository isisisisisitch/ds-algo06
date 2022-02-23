package ca.bytetube._00_leetcode.array;

public class SpiralPrint {

    public static void spiralPrint(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        //top
        int tR = 0;
        int tC = 0;
        //down
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) printEdge(matrix, tR++, tC++, dR--, dC--);

    }

    private static void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        //1.横棒
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) System.out.print(matrix[tR][i] + " ");
        }
        //2.竖棒
        else if (tC == dC) {
            for (int i = tR; i <= dR; i++) System.out.print(matrix[i][tC] + " ");
        } else {
            //3.普通矩阵
            int curR = tR;
            int curC = tC;
            while (curC != dC) {
                System.out.print(matrix[tR][curC] + " ");
                curC++;
            }

            while (curR != dR) {
                System.out.print(matrix[curR][dC] + " ");
                curR++;
            }

            while (curC != tC) {
                System.out.print(matrix[dR][curC] + " ");
                curC--;
            }

            while (curR != tR) {
                System.out.print(matrix[curR][tC] + " ");
                curR--;
            }

        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        spiralPrint(matrix);
    }
}
