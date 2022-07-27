package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/7/20 8:36
 */

public class ShiftGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < rLen; r++) {
            List<Integer> list = new ArrayList<>(cLen);
            for (int c = 0; c < cLen; c++) {
                list.add(0);
            }
            res.add(list);
        }
        int len = rLen * cLen;
        int sub = k % (rLen * cLen);
        for (int r = 0; r < rLen; r++) {
            List<Integer> list = res.get(r);
            for (int c = 0; c < cLen; c++) {
                int total = Math.abs(len + r * cLen + c - sub);
                int row = (total / cLen) % rLen;
                int col = total % cLen;
                list.set(c, grid[row][col]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ShiftGrid shiftGrid = new ShiftGrid();

        System.out.println(shiftGrid.shiftGrid(new int[][]{
                {3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}
        }, 4));

        System.out.println(shiftGrid.shiftGrid(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        }, 1));

        System.out.println(shiftGrid.shiftGrid(new int[][]{
                {1}, {2}, {3}, {4}, {7}, {6}, {5}
        }, 23));
    }

}
