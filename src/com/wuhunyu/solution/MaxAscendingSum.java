package com.wuhunyu.solution;

/**
 * 1800. 最大升序子数组和
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 8:03
 */

public class MaxAscendingSum {

    public int maxAscendingSum(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int curMax = max;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                curMax += nums[i];
            } else {
                curMax = nums[i];
            }
            max = Math.max(max, curMax);
        }
        return max;
    }

}
