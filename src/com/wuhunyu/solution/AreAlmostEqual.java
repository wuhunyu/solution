package com.wuhunyu.solution;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-11 8:30
 */

public class AreAlmostEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        int len = s1.length();
        int[] flag = new int[2];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (index > 1) {
                    return false;
                }
                flag[index++] = i;
            }
        }
        return s1.charAt(flag[0]) == s2.charAt(flag[1]) && s1.charAt(flag[1]) == s2.charAt(flag[0]);
    }

}
