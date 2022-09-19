package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 1636. 按照频率将数组升序排序
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-19 20:46
 */

public class FrequencySort {

    public int[] frequencySort(int[] nums) {
        int len = nums.length;
        int[] arr = new int[201];
        for (int num : nums) {
            arr[100 + num]++;
        }
        for (int i = 0; i < len; i++) {
            nums[i] = 10000 * arr[100 + nums[i]] + (100 - nums[i]);
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            nums[i] = 100 - nums[i] % 10000;
        }
        return nums;
    }

}
