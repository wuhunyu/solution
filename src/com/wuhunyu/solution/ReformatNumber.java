package com.wuhunyu.solution;

/**
 * 1694. 重新格式化电话号码
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-01 8:52
 */

public class ReformatNumber {

    public String reformatNumber(String number) {
        int len = number.length();
        int n = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = number.charAt(i);
            if (ch >= '0' && ch <= '9') {
                if (n++ == 3) {
                    n = 1;
                    sb.append("-");
                }
                sb.append(ch);
            }
        }
        int strLen = sb.length();
        if (strLen > 3 && n == 1) {
            sb.setCharAt(strLen - 2, sb.charAt(strLen - 3));
            sb.setCharAt(strLen - 3, '-');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReformatNumber reformatNumber = new ReformatNumber();

        System.out.println(reformatNumber.reformatNumber("123 4-5678"));
    }

}
