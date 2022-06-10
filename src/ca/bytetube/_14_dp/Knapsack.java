package ca.bytetube._14_dp;

public class Knapsack {
    public static void main(String[] args) {
        int maxValue = maxValue(new int[]{6, 3, 5, 4, 6}, new int[]{2, 2, 6, 5, 4}, 10);
        System.out.println(maxValue);
    }


    public static int maxValue(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (values.length != weights.length) return 0;
        int[]dp = new int[capacity + 1];

        for (int i = 1; i < values.length + 1; i++) {
            for (int j = capacity; j >= 1; j--) {
                //if j < weights[i – 1]，then dp(i, j) = dp(i – 1, j)
                if (j < weights[i - 1]) continue;
                else dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }
        }

        return dp[capacity];
    }


    public static int maxValue1(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (values.length != weights.length) return 0;

        int[][] dp = new int[values.length + 1][capacity + 1];
        for (int i = 1; i < values.length + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                //if j < weights[i – 1]，then dp(i, j) = dp(i – 1, j)
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];//top
                } else {
                                        //top
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }


        return dp[values.length][capacity];
    }
}
