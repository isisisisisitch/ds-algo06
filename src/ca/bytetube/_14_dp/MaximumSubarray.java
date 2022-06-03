package ca.bytetube._14_dp;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * @author dal
 */
public class MaximumSubarray {



    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        //1.dp(i) Suppose dp(i) is the sum of its maximum contiguous subarray ending in nums[i]
        int dp = nums[0];
        //initial state dp(0) = nums[0]
        int max = dp;

        for (int i = 1; i < nums.length; i++) {
            /*
            state transition equation
            if dp(i – 1) ≤ 0, dp(i) = nums[i]
            if dp(i – 1) > 0, dp(i) = dp(i – 1) + nums[i]
             */
            //1.if dp(i – 1) ≤ 0, dp(i) = nums[i]
            if (dp <= 0) dp = nums[i];
                //2.if dp(i – 1) > 0, dp(i) = dp(i – 1) + nums[i]
            else dp = dp + nums[i];
            max = Math.max(max, dp);

        }


        return max;
    }

    public int maxSubArray1(int[] nums) {
        if (nums.length == 1) return nums[0];
        //1.dp(i) Suppose dp(i) is the sum of its maximum contiguous subarray ending in nums[i]
        int[] dp = new int[nums.length];
        //initial state dp(0) = nums[0]
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < dp.length; i++) {
            /*
            state transition equation
            if dp(i – 1) ≤ 0, dp(i) = nums[i]
            if dp(i – 1) > 0, dp(i) = dp(i – 1) + nums[i]
             */
            //1.if dp(i – 1) ≤ 0, dp(i) = nums[i]
            if (dp[i - 1] <= 0) dp[i] = nums[i];
                //2.if dp(i – 1) > 0, dp(i) = dp(i – 1) + nums[i]
            else dp[i] = dp[i - 1] + nums[i];
            max = Math.max(max, dp[i]);

        }


        return max;
    }


}
