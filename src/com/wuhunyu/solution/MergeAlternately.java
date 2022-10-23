package com.wuhunyu.solution;

/**
 * 1768. 交替合并字符串
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/23 8:53
 */

public class MergeAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int index1 = 0;
        int index2 = 0;
        while (index1 < len1 || index2 < len2) {
            if (index1 < len1) {
                sb.append(word1.charAt(index1++));
            }
            if (index2 < len2) {
                sb.append(word2.charAt(index2++));
            }
        }
        return sb.toString();
    }

}
