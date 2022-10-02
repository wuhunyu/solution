package com.wuhunyu.solution;

import java.util.*;

/**
 * 6212. 删除字符使频率相同
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-01 22:31
 */

public class EqualFrequency {

    public boolean equalFrequency(String word) {
        int[] words = new int[26];
        int len = word.length();
        for (int i = 0; i < len; i++) {
            words[word.charAt(i) - 'a']++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if (words[i] != 0) {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        Map.Entry<Integer, Integer> one = iterator.next();
        if (map.size() == 1 && (one.getKey() == 1 || one.getValue() == 1)) {
            return true;
        } else if (map.size() == 2) {
            Map.Entry<Integer, Integer> two = iterator.next();
            return Math.abs(one.getKey() - two.getKey()) == 1 && (one.getValue() == 1 || two.getValue() == 1);
        }
        return false;
    }

    public static void main(String[] args) {
        EqualFrequency equalFrequency = new EqualFrequency();

        System.out.println(equalFrequency.equalFrequency("aa"));
    }

}
