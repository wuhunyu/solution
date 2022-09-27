package com.wuhunyu.solution;

/**
 * 面试题 01.02. 判定是否互为字符重排
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-27 8:25
 */

public class CheckPermutation {

    @SuppressWarnings("all")
    public boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        int[] words = new int[128];
        for (int i = 0; i < len1; i++) {
            words[s1.charAt(i)]++;
            words[s2.charAt(i)]++;
        }
        for (int i = 0; i < 128; i++) {
            if (words[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
