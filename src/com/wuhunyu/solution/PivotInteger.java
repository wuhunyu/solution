package com.wuhunyu.solution;

/**
 * 6245. 找出中枢整数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-11-27 10:31
 */

public class PivotInteger {

    public int pivotInteger(int n) {
        int sum = ((1 + n) * n) >> 1;
        int curSum = 0;
        for (int i = 1; i <= n; i++) {
            curSum += i;
            if (curSum == sum) {
                return i;
            } else if (curSum > sum) {
                return -1;
            }
            sum -= i;
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotInteger pivotInteger = new PivotInteger();

        System.out.println(pivotInteger.pivotInteger(8));
    }

}
