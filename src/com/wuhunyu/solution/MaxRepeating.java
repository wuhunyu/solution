package com.wuhunyu.solution;

/**
 * 1668. 最大重复子字符串
 *
 * @author gongzhiqiang
 * @date 2022/11/03 07:44
 **/

public class MaxRepeating {

    public int maxRepeating(String sequence, String word) {
        int sLen = sequence.length();
        int wLen = word.length();
        int count = 0;
        int sIndex = 0;
        while (sIndex < sLen) {
            if (sequence.charAt(sIndex++) == word.charAt(0)) {
                int indexCopy = sIndex - 1;
                int curCount = 0;
                while (true) {
                    int wIndex = 0;
                    while (indexCopy < sLen && wIndex < wLen && sequence.charAt(indexCopy) == word.charAt(wIndex)) {
                        indexCopy++;
                        wIndex++;
                    }
                    if (wIndex == wLen) {
                        curCount++;
                    } else {
                        break;
                    }
                }
                count = Math.max(count, curCount);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxRepeating maxRepeating = new MaxRepeating();

        System.out.println(maxRepeating.maxRepeating("ababc", "ab"));
        System.out.println(maxRepeating.maxRepeating("ababc", "ba"));
        System.out.println(maxRepeating.maxRepeating("ababc", "ac"));
        System.out.println(maxRepeating.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

}
