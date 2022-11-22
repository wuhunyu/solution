package com.wuhunyu.solution.od;

import java.util.Scanner;

/**
 * 字符串消除
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-11 21:29
 */

public class StrRemove {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (!Character.isLetter(str.charAt(i))) {
                System.out.println(0);
                return;
            }
            int left = i - 1;
            int right = i;
            while (left >= 0 && right < len && chars[left] == chars[right]) {
                chars[left--] = '0';
                chars[right++] = '0';
            }
        }
        int count = 0;
        for (char ch : chars) {
            count += ch == '0' ? 0 : 1;
        }
        System.out.println(count);
    }

}
