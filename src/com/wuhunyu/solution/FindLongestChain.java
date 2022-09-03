package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 646. 最长数对链
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-03 8:21
 */

public class FindLongestChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (arr1, arr2) -> arr1[1] - arr2[1]);
        int count = 0;
        int curVal = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (curVal < pair[0]) {
                count++;
                curVal = pair[1];
            }
        }
        return count;
    }

}
