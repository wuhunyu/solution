package com.wuhunyu.solution;

/**
 * 650. 只有两个键的键盘
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-09 21:35
 */

public class MinSteps {

    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        if (this.isPrime(n)) {
            return n;
        }
        for (int i = n >> 1; i > 1; i--) {
            if (n % i == 0) {
                return this.minSteps(i) + this.minSteps(n / i);
            }
        }
        return 0;
    }

    private boolean isPrime(int num) {
        int half = (int) Math.sqrt(num);
        while (half > 1) {
            if (num % half-- == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinSteps minSteps = new MinSteps();

        System.out.println(minSteps.minSteps(12));
    }

}
