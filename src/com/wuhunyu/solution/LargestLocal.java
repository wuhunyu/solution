package com.wuhunyu.solution;

/**
 * 6148. 矩阵中的局部最大值
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/14 10:32
 */

public class LargestLocal {

    public int[][] largestLocal(int[][] grid) {
        int len = grid.length;
        int newLen = len - 2;
        int[][] arr = {
                {-1, -1},
                {-1, 0},
                {-1, 1},
                {0, -1},
                {0, 0},
                {0, 1},
                {1, -1},
                {1, 0},
                {1, 1},
        };
        int[][] res = new int[newLen][newLen];
        for (int i = 1; i < len - 1; i++) {
            for (int j = 1; j < len - 1; j++) {
                int max = 0;
                for (int k = 0; k < 9; k++) {
                    max = Math.max(max, grid[i + arr[k][0]][j + arr[k][1]]);
                }
                res[i - 1][j - 1] = max;
            }
        }
        return res;
    }

}
