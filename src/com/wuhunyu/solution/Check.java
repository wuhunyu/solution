package com.wuhunyu.solution;

/**
 * 1752. 检查数组是否经排序和轮转得到
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-11-27 9:28
 */

public class Check {

    public boolean check(int[] nums) {
        int len = nums.length;
        boolean flag = nums[0] < nums[len - 1];
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > nums[i]) {
                if (!flag) {
                    flag = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Check check = new Check();

        System.out.println(check.check(new int[]{3, 4, 5, 1, 2}));
    }

}
