package com.wuhunyu.solution;

/**
 * 1662. 检查两个字符串数组是否相等
 *
 * @author gongzhiqiang
 * @date 2022/11/01 12:51
 **/

public class ArrayStringsAreEqual {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int index1 = 0;
        int index2 = 0;

        int index11 = 0;
        int index22 = 0;

        int len1 = word1.length;
        int len2 = word2.length;
        while (index1 < len1 && index2 < len2) {
            String str1 = word1[index1];
            String str2 = word2[index2];
            if (str1.charAt(index11++) != str2.charAt(index22++)) {
                return false;
            }
            if (index11 >= str1.length()) {
                index11 = 0;
                index1++;
            }
            if (index22 >= str2.length()) {
                index22 = 0;
                index2++;
            }
        }
        return index1 == len1 && index2 == len2;
    }

}
