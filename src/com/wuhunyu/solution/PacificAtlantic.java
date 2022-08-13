package com.wuhunyu.solution;

import java.util.*;

/**
 * 417. 太平洋大西洋水流问题
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/12 16:44
 */

public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rLen = heights.length;
        int cLen = heights[0].length;

        Set<Integer> leftTop = new HashSet<>();
        Set<Integer> rightBottom = new HashSet<>();

        for (int i = 0; i < rLen; i++) {
            this.collectPoint(heights, leftTop, i, 0);
            this.collectPoint(heights, rightBottom, i, cLen - 1);
        }
        for (int i = 0; i < cLen; i++) {
            this.collectPoint(heights, leftTop, 0, i);
            this.collectPoint(heights, rightBottom, rLen - 1, i);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                int sum = r * cLen + c;
                if (leftTop.contains(sum) && rightBottom.contains(sum)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(r);
                    list.add(c);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private final int[] rows = {-1, 0, 1, 0};

    private final int[] cols = {0, 1, 0, -1};

    private void collectPoint(int[][] heights, Set<Integer> set, int row, int col) {
        int rLen = heights.length;
        int cLen = heights[0].length;

        Queue<Integer> queue = new LinkedList<>();
        int sum = row * cLen + col;
        queue.offer(sum);
        set.add(sum);
        while (!queue.isEmpty()) {
            sum = queue.poll();
            int newRow = sum / cLen;
            int newCol = sum - cLen * newRow;

            for (int i = 0; i < 4; i++) {
                int row2 = newRow + rows[i];
                int col2 = newCol + cols[i];
                sum = row2 * cLen + col2;
                if (!set.contains(sum) &&
                        (row2 >= 0 && row2 < rLen) && (col2 >= 0 && col2 < cLen) &&
                        heights[newRow][newCol] <= heights[row2][col2]) {
                    queue.offer(sum);
                    set.add(sum);
                }
            }
        }
    }

    public static void main(String[] args) {
        PacificAtlantic pacificAtlantic = new PacificAtlantic();

        System.out.println(pacificAtlantic.pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));
    }

}
