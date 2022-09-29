package com.wuhunyu.solution;

/**
 * 面试题 01.09. 字符串轮转
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-29 9:01
 */

public class IsFlipedString {

    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

}
