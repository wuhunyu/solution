package com.wuhunyu.solution.od;

import java.util.Scanner;

/**
 * 无重复字符的元素长度乘积的最大值
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-11 17:14
 */

public class LongestSubstring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String[] strs = str.split(",");
        int len = strs.length;
        int[] words = new int[len];
        for (int i = 0; i < len; i++) {
            String s = strs[i];
            int count = 0;
            int strLen = s.length();
            for (int j = 0; j < strLen; j++) {
                count |= 1 << (s.charAt(j) - 'a');
            }
            words[i] = count;
        }
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((words[i] & words[j]) == 0) {
                    maxLen = Math.max(maxLen, strs[i].length() * strs[j].length());
                }
            }
        }
        System.out.println(maxLen);
    }

}
