package com.wuhunyu.solution;

/**
 * 74. 搜索二维矩阵
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/19 10:10
 */

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        for (int r = 0; r < rLen; r++) {
            int[] matrixRow = matrix[r];
            int left = 0;
            int right = cLen - 1;
            if (matrixRow[left] > target) {
                return false;
            } else if (matrixRow[right] < target) {
                continue;
            }
            while (left <= right) {
                int mid = ((right - left) >> 1) + left;
                if (matrixRow[mid] == target) {
                    return true;
                } else if (matrixRow[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

}
