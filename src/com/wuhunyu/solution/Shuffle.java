package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 1470. 重新排列数组
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-08-29 8:41
 */

public class Shuffle {

    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        for (int i = 0; i < len; i += 2) {
            int curIndex = i >> 1;
            nums[i] |= (nums[curIndex] & 1023) << 10;
            nums[i + 1] |= (nums[n + curIndex] & 1023) << 10;
        }
        for (int i = 0; i < len; i++) {
            nums[i] >>= 10;
        }
        return nums;
    }

    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();

        System.out.println(Arrays.toString(shuffle.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }

}
