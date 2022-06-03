package ca.bytetube._14_dp;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * @author dal
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        //dp(i) is the length of the longest increasing subsequence ending in nums[i]
        int[] dp = new int[nums.length];

        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                //2.if nums[i] ≤ nums[ j]
                if (nums[i] <= nums[j]) continue;
                //1.if nums[i] > nums[ j]  dp(i) = max { dp(i), dp( j) + 1 }
                //j ∈ [0, i)
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            max = Math.max(dp[i], max);

        }


        return max;
    }
}
