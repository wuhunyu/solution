package com.wuhunyu.solution.hot_top100.easy;

/**
 * 338. 比特位计数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 16:09
 */

public class CountBits {

    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i >>> 1] + (i & 1);
        }
        return arr;
    }

}
