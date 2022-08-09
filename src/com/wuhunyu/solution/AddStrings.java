package com.wuhunyu.solution;

/**
 * 415. 字符串相加
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/9 14:49
 */

public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int flag = 0;
        while (index1 >= 0 || index2 >= 0) {
            int sum = flag;
            if (index1 >= 0) {
                sum += num1.charAt(index1--) - '0';
            }
            if (index2 >= 0) {
                sum += num2.charAt(index2--) - '0';
            }
            flag = sum >= 10 ? (sum / 10) : 0;
            sb.append(sum % 10);
        }
        if (flag > 0) {
            sb.append(flag);
        }
        int len = sb.length();
        for (int i = len - 1; i > 0; i--) {
            if (sb.charAt(i) != '0') {
                break;
            }
            sb.deleteCharAt(i);
        }
        return sb.reverse().toString();
    }

}
