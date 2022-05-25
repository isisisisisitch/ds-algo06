package ca.bytetube._13_divide;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * @author dal
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];


        return maxSubArray(nums, 0, nums.length);
    }

    public int maxSubArray(int[] nums, int begin, int end) {
        if (end - begin < 2) return nums[begin];

        int mid = (begin + end) >> 1;
        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }

        int max = leftMax + rightMax;

        return  Math.max(max, Math.max(maxSubArray(nums, begin, mid), maxSubArray(nums, mid, end)));



    }


    public int maxSubArray2(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            int sum = 0;//表示上一次累加的和
            for (int end = begin; end < nums.length; end++) {
                //需要统计从begin到end子区间内的和
                sum += nums[end];
                max = Math.max(max, sum);

            }
        }


        return max;
    }


    public int maxSubArray1(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            for (int end = begin; end < nums.length; end++) {
                int sum = 0;

                for (int i = begin; i <= end; i++) {
                    sum += nums[i];
                }

                max = Math.max(max, sum);

            }
        }


        return max;
    }
}
