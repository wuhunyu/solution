package com.wuhunyu.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * 1805. 字符串中不同整数的数目
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/6 12:46
 */

public class NumDifferentIntegers {

    public int numDifferentIntegers(String word) {
        int len = word.length();
        int index1 = 0;
        int index2 = 0;
        Set<String> set = new HashSet<>();
        while (index1 < len) {
            while (index1 < len && word.charAt(index1) > '9') {
                index1++;
            }
            if (index1 >= len) {
                break;
            }
            index2 = index1 + 1;
            while (index2 < len && word.charAt(index2) <= '9') {
                index2++;
            }
            while (index2 > index1 + 1 && word.charAt(index1) == '0') {
                index1++;
            }
            set.add(word.substring(index1, index2));
            index1 = index2 + 1;
        }
        return set.size();
    }

    public static void main(String[] args) {
        NumDifferentIntegers numDifferentIntegers = new NumDifferentIntegers();

        System.out.println(numDifferentIntegers.numDifferentIntegers("a123bc34d8ef34"));
    }

}
