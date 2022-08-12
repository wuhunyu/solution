package com.wuhunyu.utils;

/**
 * 最大公约数（辗转相除法）
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/12 9:02
 */

public class Gcd {

    public int gcd(int num1, int num2) {
        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);
        if (min == 0) {
            return max;
        }
        return this.gcd(min, max - min);
    }

    public static void main(String[] args) {
        Gcd gcd = new Gcd();

        System.out.println(gcd.gcd(2, 3));
        System.out.println(gcd.gcd(10, 5));
    }

}
