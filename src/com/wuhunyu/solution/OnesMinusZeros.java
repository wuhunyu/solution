package com.wuhunyu.solution;

/**
 * 6277. 行和列中一和零的差值
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-11-26 22:36
 */

public class OnesMinusZeros {

    public int[][] onesMinusZeros(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        int[] rows = new int[rLen];
        int[] cols = new int[cLen];
        int[][] ans = new int[rLen][cLen];
        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                rows[r] += grid[r][c];
                cols[c] += grid[r][c];
            }
        }
        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                ans[r][c] = ((rows[r] + cols[c]) << 1) - rLen - cLen;
            }
        }
        return ans;
    }

}
