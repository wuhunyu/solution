package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 2185. 统计包含给定前缀的字符串
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2023-01-08 9:46
 */

public class PrefixCount {

    public int prefixCount(String[] words, String pref) {
        return ((int) Arrays.stream(words)
                .filter(word -> word.startsWith(pref))
                .count());
    }

}
