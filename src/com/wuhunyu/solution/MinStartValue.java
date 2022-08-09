package com.wuhunyu.solution;

/**
 * 1413. 逐步求和得到正数的最小值
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/9 8:33
 */

public class MinStartValue {

    public int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        return Math.abs(min) + 1;
    }

}
