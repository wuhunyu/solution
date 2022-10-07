package com.wuhunyu.solution.hot_top100.medium;

/**
 * 3. 无重复字符的最长子串
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 20:32
 */

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxCount = 0;
        int pre = 0;
        boolean[] words = new boolean[128];
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i);
            if (words[index]) {
                while (s.charAt(pre) != index) {
                    words[s.charAt(pre++)] = false;
                }
                pre++;
            }
            words[index] = true;
            maxCount = Math.max(maxCount, i - pre + 1);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();

        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("dvdf"));
    }

}
