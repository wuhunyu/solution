package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 1608. 特殊数组的特征值
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-12 8:02
 */

public class SpecialArray {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int specialVal = len;
        for (int i = 0; i < len; i++, specialVal--) {
            if (nums[i] >= specialVal) {
                if (i > 0 && nums[i - 1] >= specialVal) {
                    continue;
                }
                return specialVal;
            }
        }
        return -1;
    }

}
