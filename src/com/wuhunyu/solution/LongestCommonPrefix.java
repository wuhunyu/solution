package com.wuhunyu.solution;

/**
 * 14. 最长公共前缀
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/9 10:54
 */

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        int index = 0;
        while (index < strs[0].length()) {
            char ch = strs[0].charAt(index);
            for (int i = 1; i < len; i++) {
                if (index >= strs[i].length() || ch != strs[i].charAt(index)) {
                    return strs[0].substring(0, index);
                }
            }
            index++;
        }
        return strs[0].substring(0, index);
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{
                "flower", "flow", "flight"
        }));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{
                "dog", "racecar", "car"
        }));
    }

}
