package com.wuhunyu.solution;

/**
 * 1827. 最少操作使数组递增
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/11 10:07
 */

public class MinOperations2 {

    public int minOperations(int[] nums) {
        int count = 0;
        int length = nums.length;
        int pre = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] <= pre) {
                count += pre - nums[i] + 1;
                pre++;
            } else {
                pre = nums[i];
            }
        }
        return count;
    }

}
