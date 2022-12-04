package com.wuhunyu.solution;

/**
 * 6253. 回环句
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/4 10:34
 */

public class IsCircularSentence {

    public boolean isCircularSentence(String sentence) {
        String[] strs = sentence.split(" ");
        int len = strs.length;
        if (strs[0].charAt(0) != strs[len - 1].charAt(strs[len - 1].length() - 1)) {
            return false;
        }
        for (int i = 1; i < len; i++) {
            if (strs[i].charAt(0) != strs[i - 1].charAt(strs[i - 1].length() - 1)) {
                return false;
            }
        }
        return true;
    }

}
