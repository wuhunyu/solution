package com.wuhunyu.solution;

/**
 * 795. 区间子数组个数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-11-24 12:57
 */

public class NumSubarrayBoundedMax {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int len = nums.length;
        int count = 0;
        int last1 = -1;
        int last2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last1 = -1;
                last2 = i + 1;
            }
            if (last1 != -1) {
                count += last1 - last2 + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumSubarrayBoundedMax numSubarrayBoundedMax = new NumSubarrayBoundedMax();

        System.out.println(numSubarrayBoundedMax.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
        System.out.println(numSubarrayBoundedMax.numSubarrayBoundedMax(new int[]{5, 1, 1, 1, 3}, 2, 4));
    }

}
