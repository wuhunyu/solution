package com.wuhunyu.solution;

/**
 * 1417. 重新格式化字符串
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/11 8:43
 */

public class Reformat {

    public String reformat(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int numCount = 0;
        int strCount = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                numCount++;
            } else {
                strCount++;
            }
        }
        if (Math.abs(numCount - strCount) > 1) {
            return "";
        }
        int numIndex = 0;
        int strIndex = 0;
        if (numCount >= strCount) {
            strIndex = 1;
        } else {
            numIndex = 1;
        }
        char[] res = new char[len];
        for (int i = 0; i < len; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                res[numIndex] = chars[i];
                numIndex += 2;
            } else {
                res[strIndex] = chars[i];
                strIndex += 2;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Reformat reformat = new Reformat();

        System.out.println(reformat.reformat("a0b1c2"));
        System.out.println(reformat.reformat("leetcode"));
        System.out.println(reformat.reformat("1229857369"));
        System.out.println(reformat.reformat("covid2019"));
        System.out.println(reformat.reformat("ab123"));
    }

}
