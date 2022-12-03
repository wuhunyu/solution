package com.wuhunyu.solution;

/**
 * 1796. 字符串中第二大的数字
 *
 * @author gongzhiqiang
 * @date 2022/12/03 16:08
 **/

public class SecondHighest {

    public int secondHighest(String s) {
        int len = s.length();
        int firstMax = -1;
        int secondMax = -1;
        for (int i = 0; i < len; i++) {
            int cur = s.charAt(i) - '0';
            if (cur >= 10 || cur == firstMax) {
                continue;
            }
            if (cur > firstMax) {
                secondMax = firstMax;
                firstMax = cur;
            } else if (cur > secondMax) {
                secondMax = cur;
            }
        }
        return secondMax;
    }

}
