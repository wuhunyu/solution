package com.wuhunyu.solution.hot_top100.easy;

/**
 * 283. 移动零
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 16:08
 */

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        while (right < len) {
            if (nums[right] != 0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left++] = tmp;
            }
            right++;
        }
    }

}
