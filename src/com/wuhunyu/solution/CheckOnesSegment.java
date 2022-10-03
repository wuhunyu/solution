package com.wuhunyu.solution;

/**
 * 1784. 检查二进制字符串字段
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-03 10:04
 */

public class CheckOnesSegment {

    public boolean checkOnesSegment(String s) {
        for (int i = s.length() - 1; i > 1; i--) {
            if (s.charAt(i) == '1' && s.charAt(i - 1) == '0') {
                return false;
            }
        }
        return true;
    }

}
