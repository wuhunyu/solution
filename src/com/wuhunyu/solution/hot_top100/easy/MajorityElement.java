package com.wuhunyu.solution.hot_top100.easy;

/**
 * 169. 多数元素
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 12:41
 */

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int len = nums.length;
        int num = nums[0];
        int count = 1;
        int index = 1;
        while (index < len) {
            if (nums[index] == num) {
                count++;
            } else if (count == 0) {
                num = nums[index];
                count = 1;
            } else {
                count--;
            }
            index++;
        }
        return num;
    }

}
