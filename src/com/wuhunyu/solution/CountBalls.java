package com.wuhunyu.solution;

/**
 * 1742. 盒子中小球的最大数量
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-11-23 12:12
 */

public class CountBalls {

    public int countBalls(int lowLimit, int highLimit) {
        int max = 0;
        int[] arr = new int[50];
        while (lowLimit <= highLimit) {
            max = Math.max(max, ++arr[this.calNum(lowLimit++)]);
        }
        return max;
    }

    private int calNum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
