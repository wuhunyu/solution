package com.wuhunyu.solution;

/**
 * 1732. 找到最高海拔
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/11/19 8:51
 */

public class LargestAltitude {

    public int largestAltitude(int[] gain) {
        int max = 0;
        int cur = 0;
        for (int num : gain) {
            cur += num;
            max = Math.max(max, cur);
        }
        return max;
    }

}
