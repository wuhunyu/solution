package com.wuhunyu.solution;

/**
 * 1706. 球会落何处
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/9 10:35
 */

public class FindBall {

    public int[] findBall(int[][] grid) {
        int cLen = grid[0].length;
        int[] res = new int[cLen];
        for (int c = 0; c < cLen; c++) {
            res[c] = this.findSingleBall(grid, c);
        }
        return res;
    }

    private int findSingleBall(int[][] grid, int col) {
        int row = 0;
        int rLen = grid.length;
        int cLen = grid[0].length;
        while (row < rLen) {
            if (grid[row][col] == 1) {
                if (col + 1 >= cLen || grid[row][col + 1] == -1) {
                    return -1;
                }
                col++;
            } else {
                if (col - 1 < 0 || grid[row][col - 1] == 1) {
                    return -1;
                }
                col--;
            }
            row++;
        }
        return col;
    }

}
