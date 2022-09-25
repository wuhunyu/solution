package com.wuhunyu.solution;

/**
 * 6189. 按位与最大的最长子数组
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-25 10:38
 */

public class LongestSubarray {

    public int longestSubarray(int[] nums) {
        int pre = 0;
        int maxVal = 0;
        int maxCount = 1;
        int curCount = 1;
        for (int num : nums) {
            if (maxVal <= num) {
                if (num == pre) {
                    maxCount = Math.max(maxCount, ++curCount);
                } else {
                    if (maxVal < num) {
                        maxCount = 1;
                    }
                    curCount = 1;
                    maxVal = num;
                }
            }
            pre = num;
        }
        return maxCount;
    }

}
