package com.wuhunyu.solution;

/**
 * 769. 最多能完成排序的块
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/13 8:30
 */

public class MaxChunksToSorted {

    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int len = arr.length;
        int limitIndex = 0;
        for (int i = 0; i < len; i++) {
            limitIndex = Math.max(limitIndex, arr[i]);
            if (i == limitIndex) {
                count++;
            }
        }
        return count;
    }

}
