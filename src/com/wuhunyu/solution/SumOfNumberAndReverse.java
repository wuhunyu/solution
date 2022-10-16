package com.wuhunyu.solution;

/**
 * 6219. 反转之后的数字和
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/16 10:44
 */

public class SumOfNumberAndReverse {

    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            int source = i;
            int newNum = 0;
            while (source != 0) {
                newNum = newNum * 10 + source % 10;
                source /= 10;
            }
            if (i + newNum == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SumOfNumberAndReverse sumOfNumberAndReverse = new SumOfNumberAndReverse();

        System.out.println(sumOfNumberAndReverse.sumOfNumberAndReverse(0));
    }

}
