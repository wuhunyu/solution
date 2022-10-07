package com.wuhunyu.solution.hot_top100.easy;

/**
 * 70. 爬楼梯
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 9:02
 */

public class ClimbStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int count = 2;
        while (count++ < n) {
            int tmp = second;
            second += first;
            first = tmp;
        }
        return second;
    }

}
