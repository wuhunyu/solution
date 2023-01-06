package com.wuhunyu.solution;

/**
 * 2180. 统计各位数字之和为偶数的整数个数
 *
 * @author gongzhiqiang
 * @date 2023/01/06 14:18
 **/

public class CountEven {

    public int countEven(int num) {
        boolean[] dp = new boolean[num + 1];
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (((i & 1) == 1) ^ dp[i / 10]) {
                dp[i] = true;
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountEven countEven = new CountEven();

        System.out.println(countEven.countEven(30));
    }

}
