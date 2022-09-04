package com.wuhunyu.solution;

/**
 * 1582. 二进制矩阵中的特殊位置
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-04 8:58
 */

public class NumSpecial {

    public int numSpecial(int[][] mat) {
        int rLen = mat.length;
        int cLen = mat[0].length;
        int[] arr = new int[cLen];
        for (int r = 0; r < rLen; r++) {
            int curCount = 0;
            for (int c = 0; c < cLen; c++) {
                curCount += mat[r][c];
            }
            if (curCount > 0) {
                for (int c = 0; c < cLen; c++) {
                    if (mat[r][c] == 1) {
                        arr[c] += curCount;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < cLen; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        return count;
    }

}
