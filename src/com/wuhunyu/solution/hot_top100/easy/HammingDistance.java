package com.wuhunyu.solution.hot_top100.easy;

/**
 * 461. 汉明距离
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 16:10
 */

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int count = 0;
        int num = x ^ y;
        while (num != 0) {
            num &= num - 1;
            count++;
        }
        return count;
    }

}
