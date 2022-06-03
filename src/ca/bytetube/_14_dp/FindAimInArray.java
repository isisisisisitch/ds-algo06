package ca.bytetube._14_dp;

public class FindAimInArray {
    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 13};
        System.out.println(findAimInArray(arr, 12));
    }


    public static boolean findAimInArray(int[] arr, int aim) {
        if (arr == null || arr.length == 0) return false;
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];//false
        for (int i = 0; i < dp.length; i++) dp[i][aim] = true;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
//                if (dp[i + 1][j] == true) {
//                    dp[i][j] = dp[i + 1][j];
//                }
                dp[i][j] = dp[i + 1][j];
                if (j + arr[i] <= aim) dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];

            }
        }

        return dp[0][0];

    }

    public static boolean findAimInArray1(int[] arr, int aim) {
        if (arr == null || arr.length == 0) return false;

        return findAimInArray(arr, 0, 0, aim);

    }

    private static boolean findAimInArray(int[] arr, int i, int sum, int aim) {

        if (sum == aim) return true;
        if (i == arr.length) return false;

        return findAimInArray(arr, i + 1, sum + arr[i], aim) || findAimInArray(arr, i + 1, sum, aim);


    }

}
