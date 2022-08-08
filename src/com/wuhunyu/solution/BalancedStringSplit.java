package com.wuhunyu.solution;

/**
 * 1221. 分割平衡字符串
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/8 14:28
 */

public class BalancedStringSplit {

    public int balancedStringSplit(String s) {
        int len = s.length();
        int flag = s.charAt(0) == 'L' ? 1 : -1;
        int count = 0;
        for (int i = 1; i < len; i++) {
            flag += s.charAt(i) == 'L' ? 1 : -1;
            if (flag == 0) {
                count++;
            }
        }
        return count;
    }

}
