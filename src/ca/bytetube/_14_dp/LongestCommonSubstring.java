package ca.bytetube._14_dp;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("ABCBA", "BABCA"));
    }

    public static int longestCommonSubstring(String str1, String str2) {
        if (str1 == null || str2 == null) return 0;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int[] dp = new int[chars2.length + 1];
        int max = 0;
        int cur = 0;

        for (int i = 1; i < chars1.length + 1; i++) {

            for (int j = 1; j < chars2.length + 1; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = 0;
                }

                max = Math.max(dp[j], max);
            }
        }

        return max;
    }

    public static int longestCommonSubstring1(String str1, String str2) {
        if (str1 == null || str2 == null) return 0;
        if (str1.length() == 0 || str2.length() == 0) return 0;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int[][] dp = new int[chars1.length + 1][chars2.length + 1];//0
        int max = 0;

        for (int i = 1; i < chars1.length + 1; i++) {
            for (int j = 1; j < chars2.length + 1; j++) {
                //if str1[i – 1] ≠ str2[ j – 1]，then dp(i, j) = 0
                if (chars1[i - 1] != chars2[j - 1]) continue;

                //str1[i – 1] = str2[ j – 1], then dp(i, j) = dp(i – 1, j – 1) + 1
                dp[i][j] = dp[i - 1][j - 1] + 1;

                max = Math.max(dp[i][j], max);
            }

        }

        return max;

    }
}
