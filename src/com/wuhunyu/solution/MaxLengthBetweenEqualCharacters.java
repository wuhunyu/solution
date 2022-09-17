package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 1624. 两个相同字符之间的最长子字符串
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-17 9:16
 */

public class MaxLengthBetweenEqualCharacters {

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] words = new int[26];
        Arrays.fill(words, -1);
        int len = s.length();
        int maxDistance = 0;
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            if (words[index] == -1) {
                words[index] = i;
            } else {
                maxDistance = Math.max(maxDistance, i - words[index] - 1);
            }
        }
        return maxDistance;
    }

}
