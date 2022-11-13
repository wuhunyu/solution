package com.wuhunyu.solution;

/**
 * 791. 自定义字符串排序
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/11/13 10:44
 */

public class CustomSortString {

    public String customSortString(String order, String s) {
        int[] words = new int[26];
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            words[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int oLen = order.length();
        for (int i = 0; i < oLen; i++) {
            char ch = order.charAt(i);
            int index = ch - 'a';
            while (words[index] > 0) {
                sb.append(ch);
                words[index]--;
            }
        }
        for (int i = 0; i < 26; i++) {
            while (words[i] > 0) {
                sb.append(((char) i));
                words[i]--;
            }
        }
        return sb.toString();
    }

}
