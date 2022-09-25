package com.wuhunyu.solution;

/**
 * 788. 旋转数字
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-25 8:38
 */

public class RotatedDigits {

    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += this.isRotatedDigit(i) ? 1 : 0;
        }
        return count;
    }

    private boolean isRotatedDigit(int num) {
        int rotatedDigit = 0;
        while (num != 0) {
            switch (num % 10) {
                case 2:
                case 5:
                case 6:
                case 9:
                    rotatedDigit++;
                    break;
                case 0:
                case 1:
                    break;
                default:
                    return false;
            }
            num /= 10;
        }
        return rotatedDigit > 0;
    }

}
