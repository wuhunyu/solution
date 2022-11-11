package com.wuhunyu.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * 1704. 判断字符串的两半是否相似
 *
 * @author gongzhiqiang
 * @date 2022/11/11 08:11
 **/

public class HalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int len = s.length();
        int halfLen = len >> 1;
        int count = 0;
        int index = 0;
        while (index < halfLen) {
            if (set.contains(s.charAt(index))) {
                count++;
            }
            if (set.contains(s.charAt(index + halfLen))) {
                count--;
            }
            index++;
        }
        return count == 0;
    }

}
