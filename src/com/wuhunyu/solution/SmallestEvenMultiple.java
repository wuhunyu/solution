package com.wuhunyu.solution;

/**
 * 6180. 最小偶倍数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-18 10:32
 */

public class SmallestEvenMultiple {

    public int smallestEvenMultiple(int n) {
        return (n & 1) == 0 ? n : (n << 1);
    }

}
