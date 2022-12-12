package com.wuhunyu.solution;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/**
 * 1781. 所有子字符串美丽值之和
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/12 12:39
 */

public class BeautySum {

    public int beautySum(String s) {
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            int[] arr = new int[26];
            for (int j = i; j < length; j++) {
                int num = s.charAt(j) - 'a';
                arr[num]++;
                IntSummaryStatistics summaryStatistics = IntStream.of(arr)
                        .filter(el -> el > 0)
                        .summaryStatistics();
                count += summaryStatistics.getMax() - summaryStatistics.getMin();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BeautySum beautySum = new BeautySum();

        System.out.println(beautySum.beautySum("aabcb"));
    }

}
