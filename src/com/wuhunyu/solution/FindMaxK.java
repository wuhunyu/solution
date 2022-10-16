package com.wuhunyu.solution;

/**
 * 6204. 与对应负数同时存在的最大正整数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/16 10:31
 */

public class FindMaxK {

    public int findMaxK(int[] nums) {
        int[] arr = new int[1001];
        for (int num : nums) {
            int abs = Math.abs(num);
            if (arr[abs] == 2) {
                continue;
            }
            boolean isPositive = num > 0;
            if (arr[abs] == 0) {
                arr[abs] = isPositive ? 1 : -1;
            } else if (arr[abs] == 1 && !isPositive) {
                arr[abs] = 2;
            } else if (arr[abs] == -1 && isPositive) {
                arr[abs] = 2;
            }
        }
        for (int i = 1000; i > 0; i--) {
            if (arr[i] == 2) {
                return i;
            }
        }
        return -1;
    }

}
