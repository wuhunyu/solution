package com.wuhunyu.solution;

/**
 * 6169. 最长优雅子数组
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-04 10:42
 */

public class longestNiceSubarray {

    public int longestNiceSubarray(int[] nums) {
        int len = nums.length;
        int max = 1;
        for (int i = 0; i < len; i++) {
            int flag = nums[i];
            for (int j = i + 1; j < len; j++) {
                if ((flag & nums[j]) != 0) {
                    break;
                }
                flag |= nums[j];
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

}
