package ca.bytetube._14_dp;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * @author dal
 */
public class CoinChange {

    public static void main(String[] args) {
        int coins = coinChange(41);
        System.out.println(coins);
    }

    /**
     * 由coinChange2记忆画搜索知，要计算较大的amount所对应的硬币数，需要先计算较小的amount所对应的硬币数
     * iteration：直接先计算较小的amount所对应的硬币数，再依次计算较大的amount所对应的硬币数
     */
    public static int coinChange(int amount) {//n = 4
        if (amount < 1) return -1;
        int[] dp = new int[amount + 1];//dp[n]的意义：表示凑够n分零钱时所需要的硬币数
        for (int i = 1; i <= amount; i++) {//i = 28 dp[1~27]我们都知道
            int min = Integer.MAX_VALUE;

            if (i >= 1) min = Math.min(dp[i - 1], min);//dp[27]
            if (i >= 5) min = Math.min(dp[i - 5], min);//dp[23]
            if (i >= 20) min = Math.min(dp[i - 20], min);
            if (i >= 25) min = Math.min(dp[i - 25], min);

            dp[i] = min + 1;

            System.out.println(dp[i]);
        }


        return dp[amount];
    }

    public static int coinChange2(int amount) {//n = 4
        if (amount < 1) return -1;
        int[] dp = new int[amount + 1];//dp[n]的意义：表示凑够n分零钱时所需要的硬币数
        int[] coins = {1, 5, 20, 25};
        for (int coin : coins) {
            if (amount < coin) break;
            dp[coin] = 1;
        }

        return coinChange(amount, dp);
    }

    private static int coinChange(int amount, int[] dp) {//n = 4
        if (amount < 1) return Integer.MAX_VALUE;

        if (amount == 25 || amount == 20 || amount == 5 || amount == 1) return 1;

        if (dp[amount] == 0) {
            int min1 = Math.min(coinChange(amount - 25, dp), coinChange(amount - 20, dp));

            int min2 = Math.min(coinChange(amount - 5, dp), coinChange(amount - 1, dp));

            dp[amount] = Math.min(min1, min2) + 1;
        }


        return dp[amount];

    }


    /**
     * coins(6) -> coins(1) + coins(5);
     * coins(5) -> coins(4);
     * coins(4) -> coins(3);
     * coins(3) -> coins(2);
     * coins(2) -> coins(1);
     */
    public static int coinChange1(int n) {//n = 4
        if (n < 1) return Integer.MAX_VALUE;

        if (n == 25 || n == 20 || n == 5 || n == 1) return 1;

        int min1 = Math.min(coinChange1(n - 25), coinChange1(n - 20));

        int min2 = Math.min(coinChange1(n - 5), coinChange1(n - 1));

        return Math.min(min1, min2) + 1;
    }

}
