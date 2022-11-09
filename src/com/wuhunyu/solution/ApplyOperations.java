package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 6229. 对数组执行操作
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/11/6 10:32
 */

public class ApplyOperations {

    public int[] applyOperations(int[] nums) {
        int len = nums.length;
        int index = 0;
        while (index < len - 1) {
            if (nums[index] == nums[index + 1]) {
                nums[index] <<= 1;
                nums[index + 1] = 0;
                index++;
            }
            index++;
        }
        int index1 = 0;
        int index2 = 0;
        while (index2 < len) {
            if (nums[index2] != 0) {
                int tmp = nums[index2];
                nums[index2] = nums[index1];
                nums[index1++] = tmp;
            }
            index2++;
        }
        return nums;
    }

    public static void main(String[] args) {
        ApplyOperations applyOperations = new ApplyOperations();

        System.out.println(Arrays.toString(applyOperations.applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
    }

}
