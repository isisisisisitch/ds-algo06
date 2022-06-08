package ca.bytetube._14_dp;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * @author dal
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 4, 9, 1};
        int[] nums2 = {1, 4, 9, 10};
        int commonSubsequence = longestCommonSubsequence(nums1, nums2);
        System.out.println(commonSubsequence);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        char[] rowNums = chars1, colNums = chars2;
        if (chars1.length < chars2.length) {
            colNums = chars1;
            rowNums = chars2;
        }

        int[] dp = new int[colNums.length + 1];

        for (int row = 1; row < rowNums.length + 1; row++) {

            int cur = 0;
            for (int col = 1; col < colNums.length + 1; col++) {
                int leftTop = cur;
                cur = dp[col];
                //1. nums1[row – 1] = nums2[ j – 1]，
                // dp(row, j) = dp(row – 1, j – 1) + 1
                if (rowNums[(row - 1)] == colNums[col - 1]) dp[col] = leftTop + 1;

                    //2.nums1[row – 1] ≠ nums2[ j – 1]，
                    // dp(row, j) = max { dp(row – 1, j), dp(row, j – 1) }
                else dp[col] = Math.max(dp[col - 1], dp[col]);
            }
        }

        return dp[colNums.length];

    }

    public static int longestCommonSubsequence(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0;
        if (nums1.length == 0 || nums2.length == 0) return 0;
        int[] rowNums = nums1, colNums = nums2;

        if (nums1.length < nums2.length) {
            colNums = nums1;
            rowNums = nums2;
        }

        int[] dp = new int[colNums.length + 1];

        for (int row = 1; row < rowNums.length + 1; row++) {

            int cur = 0;
            for (int col = 1; col < colNums.length + 1; col++) {
                int leftTop = cur;
                cur = dp[col];
                //1. nums1[row – 1] = nums2[ j – 1]，
                // dp(row, j) = dp(row – 1, j – 1) + 1
                if (rowNums[(row - 1)] == colNums[col - 1]) dp[col] = leftTop + 1;

                    //2.nums1[row – 1] ≠ nums2[ j – 1]，
                    // dp(row, j) = max { dp(row – 1, j), dp(row, j – 1) }
                else dp[col] = Math.max(dp[col - 1], dp[col]);
            }
        }

        return dp[colNums.length];
    }


    public static int longestCommonSubsequence4(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0;
        if (nums1.length == 0 || nums2.length == 0) return 0;

        int[] dp = new int[nums2.length + 1];

        for (int i = 1; i < nums1.length + 1; i++) {

            int cur = 0;
            for (int j = 1; j < nums2.length + 1; j++) {
                int leftTop = cur;
                cur = dp[j];
                //1. nums1[i – 1] = nums2[ j – 1]，dp(i, j) = dp(i – 1, j – 1) + 1
                if (nums1[(i - 1)] == nums2[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    //2.nums1[i – 1] ≠ nums2[ j – 1]，dp(i, j) = max { dp(i – 1, j), dp(i, j – 1) }
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
            }
        }

        return dp[nums2.length];
    }

    public static int longestCommonSubsequence3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0;
        if (nums1.length == 0 || nums2.length == 0) return 0;

        int[][] dp = new int[2][nums2.length + 1];//table view

        for (int i = 1; i < nums1.length + 1; i++) {
            int row = i & 1;
            int preRow = (i - 1) & 1;
            for (int j = 1; j < nums2.length + 1; j++) {
                //1. nums1[i – 1] = nums2[ j – 1]，dp(i, j) = dp(i – 1, j – 1) + 1
                if (nums1[(i - 1)] == nums2[j - 1]) {
                    dp[row][j] = dp[preRow][j - 1] + 1;
                } else {
                    //2.nums1[i – 1] ≠ nums2[ j – 1]，dp(i, j) = max { dp(i – 1, j), dp(i, j – 1) }
                    dp[row][j] = Math.max(dp[(preRow) & 1][j], dp[row][j - 1]);
                }
            }
        }

        return dp[(nums1.length & 1)][nums2.length];
    }

    public static int longestCommonSubsequence2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0;
        if (nums1.length == 0 || nums2.length == 0) return 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                //1. nums1[i – 1] = nums2[ j – 1]，dp(i, j) = dp(i – 1, j – 1) + 1
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //2.nums1[i – 1] ≠ nums2[ j – 1]，dp(i, j) = max { dp(i – 1, j), dp(i, j – 1) }
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }

    public static int longestCommonSubsequence1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0;
        if (nums1.length == 0 || nums2.length == 0) return 0;

        return longestCommonSubsequence1(nums1, nums1.length, nums2, nums2.length);
    }

    private static int longestCommonSubsequence1(int[] nums1, int i, int[] nums2, int j) {
        if (i == 0 || j == 0) return 0;

        //nums1[i – 1] = nums2[ j – 1]，dp(i, j) = dp(i – 1, j – 1) + 1
        if (nums1[i - 1] == nums2[j - 1]) {
            return longestCommonSubsequence1(nums1, i - 1, nums2, j - 1) + 1;
        }
        //nums1[i – 1] ≠ nums2[ j – 1]，dp(i, j) = max { dp(i – 1, j), dp(i, j – 1) }
        return Math.max(longestCommonSubsequence1(nums1, i - 1, nums2, j),
                longestCommonSubsequence1(nums1, i, nums2, j - 1));


    }

}
