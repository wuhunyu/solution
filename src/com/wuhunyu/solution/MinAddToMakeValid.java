package com.wuhunyu.solution;

/**
 * 921. 使括号有效的最少添加
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-04 8:17
 */

public class MinAddToMakeValid {

    public int minAddToMakeValid(String s) {
        int len = s.length();
        int left = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left++;
            } else if (left > 0) {
                left--;
            } else {
                right++;
            }
        }
        return left + right;
    }

}
