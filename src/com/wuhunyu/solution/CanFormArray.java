package com.wuhunyu.solution;

/**
 * 1640. 能否连接形成数组
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-22 8:22
 */

public class CanFormArray {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] flag = new int[101];
        int pLen = pieces.length;
        for (int i = 0; i < pLen; i++) {
            flag[pieces[i][0]] = i;
        }
        int index = 0;
        int len = arr.length;
        while (index < len) {
            int[] piece = pieces[flag[arr[index]]];
            for (int num : piece) {
                if (arr[index++] != num) {
                    return false;
                }
            }
        }
        return true;
    }

}
