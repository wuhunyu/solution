package com.wuhunyu.solution.od;

import java.util.Scanner;

/**
 * 非严格递增连续数字序列
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-11 17:26
 */

public class IncreaseNumSubsequences {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int len = str.length();
        int index = 0;
        int curCount = 0;
        int maxLen = 0;
        char pre = 'a';
        while (index < len) {
            char ch = str.charAt(index++);
            if (ch >= '0' && ch <= '9') {
                if (ch >= pre) {
                    curCount++;
                } else {
                    curCount = 1;
                }
                maxLen = Math.max(maxLen, curCount);
            }
            pre = ch;
        }
        System.out.println(maxLen);
    }

}
