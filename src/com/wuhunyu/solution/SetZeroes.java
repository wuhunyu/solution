package com.wuhunyu.solution;

/**
 * 面试题 01.08. 零矩阵
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-30 9:43
 */

public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        boolean rowBlank = false;
        boolean colBlank = false;
        for (int i = 0; i < cLen; i++) {
            if (matrix[0][i] == 0) {
                rowBlank = true;
                break;
            }
        }
        for (int i = 0; i < rLen; i++) {
            if (matrix[i][0] == 0) {
                colBlank = true;
                break;
            }
        }
        for (int r = 1; r < rLen; r++) {
            for (int c = 1; c < cLen; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        for (int r = rLen - 1; r >= 0; r--) {
            for (int c = cLen - 1; c >= 0; c--) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0 ||
                        r == 0 && rowBlank || c == 0 && colBlank) {
                    matrix[r][c] = 0;
                }
            }
        }
    }

}
