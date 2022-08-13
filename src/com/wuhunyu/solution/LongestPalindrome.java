package com.wuhunyu.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 2131. 连接两字母单词得到的最长回文串
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/13 8:40
 */

public class LongestPalindrome {

    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        boolean isSame = false;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (key.charAt(0) == key.charAt(1)) {
                count += value >> 1;
                isSame |= (value & 1) == 1;
                continue;
            }
            if (value <= 0) {
                continue;
            }
            String revertStr = String.valueOf(key.charAt(1)) + key.charAt(0);
            Integer anotherValue = map.get(revertStr);
            if (anotherValue != null) {
                count += Math.min(value, anotherValue);
                map.put(revertStr, 0);
            }
        }
        return (isSame ? 2 : 0) + (count << 2);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();

        System.out.println(longestPalindrome.longestPalindrome(new String[]{"lc", "cl", "gg"}));
        System.out.println(longestPalindrome.longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"}));
        System.out.println(longestPalindrome.longestPalindrome(new String[]{"cc", "ll", "xx"}));
        System.out.println(longestPalindrome.longestPalindrome(new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"}));
        System.out.println(longestPalindrome.longestPalindrome(new String[]{"qo", "fo", "fq", "qf", "fo", "ff", "qq", "qf", "of", "of", "oo", "of", "of", "qf", "qf", "of"}));
    }

}
