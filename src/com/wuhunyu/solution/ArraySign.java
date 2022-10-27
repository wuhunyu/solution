package com.wuhunyu.solution;

/**
 * 1822. 数组元素积的符号
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/27 12:51
 */

public class ArraySign {

    public int arraySign(int[] nums) {
        int negative = 0;
        for (int num : nums) {
            if (num < 0) {
                negative++;
            } else if (num == 0) {
                return 0;
            }
        }
        return (negative & 1) == 1 ? -1 : 1;
    }

}
