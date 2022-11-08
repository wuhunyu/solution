package com.wuhunyu.solution;

/**
 * 1684. 统计一致字符串的数目
 *
 * @author gongzhiqiang
 * @date 2022/11/08 08:05
 **/

public class CountConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        int flag = 0;
        for (int i = 0; i < allowed.length(); i++) {
            flag |= 1 << (allowed.charAt(i) - 'a');
        }
        int count = 0;
        for (String word : words) {
            int len = word.length();
            boolean success = true;
            for (int i = 0; i < len; i++) {
                if ((flag & (1 << (word.charAt(i) - 'a'))) == 0) {
                    success = false;
                    break;
                }
            }
            if (success) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountConsistentStrings countConsistentStrings = new CountConsistentStrings();

        System.out.println(countConsistentStrings.countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }

}
