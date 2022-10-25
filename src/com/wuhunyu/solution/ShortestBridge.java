package com.wuhunyu.solution;

import java.util.*;

/**
 * 934. 最短的桥
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/10/25 7:55
 */

public class ShortestBridge {

    public int shortestBridge(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        int zeroCount = 0;
        List<Integer>[] lists = new List[2];
        Set<Integer> set = new HashSet<>();
        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                int sum = r * cLen + c;
                if (grid[r][c] == 1 && !set.contains(sum)) {
                    lists[zeroCount] = new ArrayList<>();
                    this.dfs(r, c, grid, set, lists[zeroCount]);
                    zeroCount++;
                }
                if (zeroCount == 2) {
                    break;
                }
            }
        }
        List<Integer> list1 = lists[0];
        List<Integer> list2 = lists[1];
        int min = Integer.MAX_VALUE;
        for (Integer li1 : list1) {
            int li1Row = li1 / cLen;
            int li1Col = li1 % cLen;
            for (Integer li2 : list2) {
                int li2Row = li2 / cLen;
                int li2Col = li2 % cLen;
                min = Math.min(min, Math.abs(li1Row - li2Row) + Math.abs(li1Col - li2Col) - 1);
            }
        }
        return min;
    }

    private void dfs(int row, int col, int[][] grid, Set<Integer> uniqueNum, List<Integer> list) {
        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, 1, 0, -1};
        int rLen = grid.length;
        int cLen = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(row * cLen + col);
        while (!queue.isEmpty()) {
            Integer sum = queue.poll();
            int curRow = sum / cLen;
            int curCol = sum % cLen;
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                int newRow = curRow + rows[i];
                int newCol = curCol + cols[i];
                if (newRow >= 0 && newRow < rLen && newCol >= 0 && newCol < cLen && grid[newRow][newCol] == 1) {
                    int newSum = newRow * cLen + newCol;
                    if (set.contains(newSum)) {
                        flag = false;
                        continue;
                    }
                    set.add(newSum);
                    uniqueNum.add(newSum);
                    queue.offer(newSum);
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                list.add(sum);
            }
        }
    }

    public static void main(String[] args) {
        ShortestBridge shortestBridge = new ShortestBridge();

        System.out.println(shortestBridge.shortestBridge(new int[][] {{0, 1}, {1, 0}}));
        System.out.println(shortestBridge.shortestBridge(new int[][] {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}}));
    }

}
