package com.wuhunyu.solution;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/21 8:50
 */

public class IsPrefixOfWord {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.split(" ");
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            if (strs[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

}
