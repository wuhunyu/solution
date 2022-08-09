package com.wuhunyu.solution;

/**
 * 6132. 使数组中所有元素都等于零
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/7/31 10:34
 */

public class MinimumOperations {

    public int minimumOperations(int[] nums) {
        int[] arr = new int[101];
        for (int num : nums) {
            arr[num] = 1;
        }
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            count += arr[i];
        }
        return count;
    }

}
