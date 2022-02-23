package ca.bytetube._00_leetcode.array;

public class FindTargetInOrderArrays {

    public static boolean findTargetInOrderArrays(int[][] matrix,int target){
     int curRow = 0;
     int curCol = matrix[0].length - 1;

     while (curRow < matrix.length && curCol > -1){
         if (matrix[curRow][curCol] == target){
             return true;
         }
         else if (matrix[curRow][curCol] > target) {
             curCol--;
         }else  {

             curRow++;
         }
     }

        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = {{3,5,9,13},{4,10,17,23},{8,14,23,52},{9,27,35,93}};
        System.out.println(findTargetInOrderArrays(matrix,100));
    }
}
