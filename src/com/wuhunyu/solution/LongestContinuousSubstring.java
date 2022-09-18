package com.wuhunyu.solution;

/**
 * 6181. 最长的字母序连续子字符串的长度
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-18 10:33
 */

public class LongestContinuousSubstring {

    public int longestContinuousSubstring(String s) {
        int len = s.length();
        int max = 0;
        int curLen = 0;
        char pre = '0';
        int index = 0;
        while (index < len) {
            char curCh = s.charAt(index++);
            curLen = curCh == pre + 1 ? curLen + 1 : 1;
            max = Math.max(max, curLen);
            pre = curCh;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestContinuousSubstring longestContinuousSubstring = new LongestContinuousSubstring();

        System.out.println(longestContinuousSubstring.longestContinuousSubstring("abacaba"));
    }

}
