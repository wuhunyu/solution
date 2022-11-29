package com.wuhunyu.solution;

/**
 * 1758. 生成交替二进制字符串的最少操作数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/11/29 12:56
 */

public class MinimumChangesToMakeAlternatingBinaryString {

    public int minOperations(String s) {
        int len = s.length();
        int zeroFirst = 0;
        for (int i = 0; i < len; i++) {
            zeroFirst += (i & 1) ^ (s.charAt(i) - '0');
        }
        return Math.min(zeroFirst, len - zeroFirst);
    }

}
